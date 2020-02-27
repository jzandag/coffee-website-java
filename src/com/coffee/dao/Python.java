package com.coffee.dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Python {
	
	public static Integer coffeeCheck(){
		final String PYTHON_PATH = "PYTHON_PATH";

		try {

			// pagkuha ng path sa env variables
			String pythonPath = System.getenv(PYTHON_PATH);

			String[] env = null;
			// pwede magdagdag ng parameters para idagdag lang saa string array
			String[] callAndArgs = {"python", "coffeeCheck.py"};

			Process p = Runtime.getRuntime().exec(callAndArgs, env, new java.io.File(pythonPath));

			BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));// getting
																									// the
																									// input

			BufferedReader stdError = new BufferedReader(new InputStreamReader(p.getErrorStream()));// getting
																									// the
																									// error

			String command_result = stdInput.readLine();// reading the output
		
			return Integer.parseInt(command_result.trim());
		} catch (IOException e) {
			System.out.println("exception occured");
			e.printStackTrace();
			return 0;
		}
	}
	
	public static Integer creamerCheck(){
		final String PYTHON_PATH = "PYTHON_PATH";

		try {

			// pagkuha ng path sa env variables
			String pythonPath = System.getenv(PYTHON_PATH);

			String[] env = null;
			// pwede magdagdag ng parameters para idagdag lang saa string array
			String[] callAndArgs = {"python", "creamerCheck.py"};

			Process p = Runtime.getRuntime().exec(callAndArgs, env, new java.io.File(pythonPath));

			BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));// getting

			BufferedReader stdError = new BufferedReader(new InputStreamReader(p.getErrorStream()));// getting

			String command_result = stdInput.readLine();// reading the output
			
			return Integer.parseInt(command_result.trim());
		} catch (IOException e) {
			System.out.println("exception occured");
			e.printStackTrace();
			return 0;
		}
	}
	
	public static Integer sugarCheck(){
		final String PYTHON_PATH = "PYTHON_PATH";

		try {

			// pagkuha ng path sa env variables
			String pythonPath = System.getenv(PYTHON_PATH);

			String[] env = null;
			// pwede magdagdag ng parameters para idagdag lang saa string array
			String[] callAndArgs = {"python", "sugarCheck.py"};

			Process p = Runtime.getRuntime().exec(callAndArgs, env, new java.io.File(pythonPath));

			BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));// getting
																									// the
																									// input

			BufferedReader stdError = new BufferedReader(new InputStreamReader(p.getErrorStream()));// getting
																									// the
																									// error

			String command_result = stdInput.readLine();// reading the output
			
			return Integer.parseInt(command_result.trim());
		} catch (IOException e) {
			System.out.println("exception occured");
			e.printStackTrace();
			return 0;
		}
	}
	
	public static Integer cup1(){
		final String PYTHON_PATH = "PYTHON_PATH";

		try {

			// pagkuha ng path sa env variables
			String pythonPath = System.getenv(PYTHON_PATH);

			String[] env = null;
			// pwede magdagdag ng parameters para idagdag lang saa string array
			String[] callAndArgs = {"python", "cup1.py"};

			Process p = Runtime.getRuntime().exec(callAndArgs, env, new java.io.File(pythonPath));

			BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));// getting

			BufferedReader stdError = new BufferedReader(new InputStreamReader(p.getErrorStream()));// getting

			String command_result = stdInput.readLine();// reading the output
			
			return Integer.parseInt(command_result.trim());
		} catch (IOException e) {
			System.out.println("exception occured");
			e.printStackTrace();
			return 0;
		}
	}
	
	public static Integer cup2(){
		final String PYTHON_PATH = "PYTHON_PATH";

		try {

			// pagkuha ng path sa env variables
			String pythonPath = System.getenv(PYTHON_PATH);

			String[] env = null;
			// pwede magdagdag ng parameters para idagdag lang saa string array
			String[] callAndArgs = {"python", "cup2.py"};

			Process p = Runtime.getRuntime().exec(callAndArgs, env, new java.io.File(pythonPath));

			BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));// getting

			BufferedReader stdError = new BufferedReader(new InputStreamReader(p.getErrorStream()));// getting

			String command_result = stdInput.readLine();// reading the output
			
			return Integer.parseInt(command_result.trim());
		} catch (IOException e) {
			System.out.println("exception occured");
			e.printStackTrace();
			return 0;
		}
	}
	
	public static Integer ir(){
		final String PYTHON_PATH = "PYTHON_PATH";

		try {

			// pagkuha ng path sa env variables
			String pythonPath = System.getenv(PYTHON_PATH);

			String[] env = null;
			// pwede magdagdag ng parameters para idagdag lang saa string array
			String[] callAndArgs = {"python", "ir.py"};

			Process p = Runtime.getRuntime().exec(callAndArgs, env, new java.io.File(pythonPath));

			BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));// getting

			BufferedReader stdError = new BufferedReader(new InputStreamReader(p.getErrorStream()));// getting

			String command_result = stdInput.readLine();// reading the output
			
			return Integer.parseInt(command_result.trim());
		} catch (IOException e) {
			System.out.println("exception occured");
			e.printStackTrace();
			return 0;
		}
	}
	
	public static Integer fs(){
		final String PYTHON_PATH = "PYTHON_PATH";

		try {

			// pagkuha ng path sa env variables
			String pythonPath = System.getenv(PYTHON_PATH);

			String[] env = null;
			// pwede magdagdag ng parameters para idagdag lang saa string array
			String[] callAndArgs = {"python", "float.py"};

			Process p = Runtime.getRuntime().exec(callAndArgs, env, new java.io.File(pythonPath));

			BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));// getting

			BufferedReader stdError = new BufferedReader(new InputStreamReader(p.getErrorStream()));// getting

			String command_result = stdInput.readLine();// reading the output
			
			return Integer.parseInt(command_result.trim());
		} catch (IOException e) {
			System.out.println("exception occured");
			e.printStackTrace();
			return 0;
		}
	}
}
