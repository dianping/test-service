package com.dianping.test.service.page.task;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import redis.clients.jedis.Jedis;

import com.dianping.test.service.page.task.Task.TaskStatus;

public class TaskManager {
	private List<Task> m_tasks = new ArrayList<Task>();
	Jedis jedis = RedisLink.getJeis();
	
	private String job = "{\"case_id\":\"@uuid\",\"timeout\":\"1200\",\"run_id\":\"@run_id\",\"type\":\"automation\",\"host\":\"@host\",\"port\":\"@port\",\"conf\":{\"mode\":\"local\",\"job\":\"@job\",\"env\":\"@env\"}}";

	public boolean submitTask(Task task) {
		// TODO do real job here
		task.setId(UUID.randomUUID().toString());

//		if (m_tasks.size() % 2 == 0) {
//			task.setStatus(TaskStatus.DONE);
//		} else {
		task.setStatus(TaskStatus.PENDING);
//		}
		if(task.getFeature()==null || task.getFeature().equals(""))
			return false;
		String[] jobs = task.getFeature().split("\\|");
		
		for(int i=0; i<jobs.length; ++i) {
			String str = job.replaceFirst("@uuid", task.getId());
			str = str.replaceFirst("@run_id", task.getId()+i);
			if(task.getHost() != null) 
				str = str.replaceFirst("@host", task.getHost());
			else
				str = str.replaceFirst("@host", "");
			str = str.replaceFirst("@job", "http://192.168.8.45:81/svn/dianping/dptest/dpautomation/" + jobs[i]);
			if(task.getEnv() != null)
				str = str.replaceFirst("@env", task.getEnv());
			else
				str = str.replaceFirst("@env", "");
			str = str.replaceFirst("@port", ""+task.getPort());
//			String str = job.replaceAll("@uuid", task.getId()).replaceFirst("@host", task.getHost()).replaceFirst("@port", ""+task.getPort()).replaceFirst(
//					"@job", "http://192.168.8.45:81/svn/dianping/dptest/dpautomation/" + jobs[i]).replaceFirst("@env", task.getEnv());
			jedis.rpush("task", str);
			System.out.println(str);
		}
		
		m_tasks.add(task);
		return true;
	}
	
	public TaskStatus getStatus(String id, int jobNum) {
		String[] col = new String[jobNum];
		for(int i=0; i<jobNum; ++i){

			String job_str = jedis.hget("taskstatus", id+","+id+i);
//			System.out.println("task: "+task_str);
			try {
//				System.out.println(task_str);
				if(job_str == null)
					continue;
	            JSONObject jsonObj = new JSONObject(job_str);
//	            JSONObject jsonClass = new JSONObject(jsonObj.getString("machine"));
//	            System.out.println(jsonObj.toString());
	            JSONObject jo = jsonObj.getJSONObject("machine");
	            String str = jo.toString();
	            String jsonstr = str.substring(str.indexOf("\":")+2,str.length()-1);
	            JSONObject jo1 = new JSONObject(jsonstr);
	            String status = jo1.getString("status");
	            col[i] = status;
	    		System.out.println("status: " + col[i]);
	        } catch (JSONException e) {
	        	e.printStackTrace();
	        }
		}
        return calStatus(col);
	}
	
	private TaskStatus calStatus(String[] col) {
		System.out.println("Job number: " + col.length);
		boolean aborted = false;
		boolean pending = false; 
		boolean running = false;
		for(int i=0; i<col.length; ++i) {
			if(col[i] == null)
				return TaskStatus.PENDING;
			if(col[i].equals(TaskStatus.FAIL.getName()))
				return TaskStatus.FAIL;
			else if(col[i].equals(TaskStatus.ABORTED.getName()))
				aborted = true;
			else if(col[i].equals(TaskStatus.PENDING.getName()))
				pending = true;
			else if(col[i].equals(TaskStatus.RUNNING.getName()))
				running = true;
			else if(col[i].equals(TaskStatus.SUCCESS.getName()));
			else
				System.out.println("Unknown status: " + col[i]);
		}
		if(aborted)
			return TaskStatus.ABORTED;
		if(pending)
			return TaskStatus.PENDING;
		if(running)
			return TaskStatus.RUNNING;
		return TaskStatus.SUCCESS;
	}

	public Task getTask(String id) {
		for (Task task : m_tasks) {
			if (task.getId().equals(id)) {
				return task;
			}
		}

		return null;
	}

	public List<Task> listActiveTasks() {
		return m_tasks;
	}
}
