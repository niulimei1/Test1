package com.usersadmin.test;

import java.util.*;
import java.io.File;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * 管理用户的类
 */
public class UsersAdmin {
	static Users[] Users = new Users[1000];// 定义用户数组，容量为100
	static int num = 0;
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		while (true) {
			System.out.println("-----疫情上报系统首页-------");
			System.out.println("1:用户		2:管理员");
			System.out.println("------------------------");
			System.out.println("请选择您的身份：");
			Scanner sc = new Scanner(System.in);
			int i = sc.nextInt();
			while (true) {
				if (i == 1) {
					System.out.println("-----欢迎进入疫情上报系统-----");
					System.out.println("01:录入自己当天疫情信息");
					System.out.println("02:查询自己某一天的疫情情况");
					System.out.println("03:退出系统");
					System.out.println("-------------------------");
					System.out.println("请选择操作：");
					int a = sc.nextInt();
					switch (a) {
					case 01:
						add();// 添加用户疫情信息
						break;
					case 02:
						query();// 查询某个用户某一天的疫情信息
						break;
					case 03:
						break;
					default:
						System.out.print("Error");
					}
					break;

				}
				if (i == 2) {
					System.out.println("-----欢迎进入疫情上报系统-----");
					System.out.println("10:浏览用户疫情信息总表");
					System.out.println("11:查询用户某天疫情信息");
					System.out.println("12:修改用户某天疫情信息");
					System.out.println("13:删除用户某天疫情信息");
					System.out.println("14:查看有疫情疑似症状的用户信息");// 包括统计的个数
					System.out.println("15:查看目前处于隔离期的用户信息");// 包括统计的个数
					System.out.println("16:退出系统");
					System.out.println("-------------------");
					System.out.println("请选择操作：");
					int b = sc.nextInt();
					switch (b) {
					case 10:
						show();// 浏览所填报用户的疫情信息
						break;
					case 11:
						query();// 查询某个用户某一天的疫情信息
						break;
					case 12:
						change();// 修改某个用户某一天的疫情信息
						break;
					case 13:
						delete();// 删除某个用户某一天的疫情信息
						break;
					case 14:
						statumessage();// 统计有疫情疑似症状的用户信息
						break;
					case 15:
						isolationmessage();// 统计统计被隔离用户的信息
						break;
					case 16:
						break;
					default:
						System.out.print("Error");
					}
					break;
				}
			}
		}
	}

	/* 浏览所填报用户的疫情信息 */
	public static void show() {
		int i;
		for (i = 0; i < num; i++) {
			System.out.println(
					"-----------------------------------------------------------------------------------------");
			System.out.println(
					"姓名             联系电话                      职位              学院         当前所在省      是否有疑似症状      是否处于隔离期                填报日期");
			System.out.println(Users[i].getName() + "\t" + Users[i].getNumber() + "\t" + Users[i].getPosition() + "\t"
					+ Users[i].getXueyuan() + "\t" + Users[i].getProvince() + "\t\t" + Users[i].getStatus() + "\t"
					+ Users[i].getIsolation() + "\t\t" + Users[i].getDate());
			System.out.println(
					"-----------------------------------------------------------------------------------------");
			System.out.println(" ");
		}
	}

	/* 添加用户疫情信息 */
	public static void add() {
		/*
		 * while(true) { System.out.println("请输入2数字继续添加学生信息，返回首页请输入1");
		 * if(scanner.nextInt()==1) { break; }
		 */

		System.out.println("请输入该学生的姓名，联系电话，职位，学院，当前所在省，  是否有疑似症状，是否处于隔离期，填报日期");
		Users[num] = new Users();
		Users[num].setName(scanner.next());
		Users[num].setNumber(scanner.next());
		Users[num].setPosition(scanner.next());
		Users[num].setXueyuan(scanner.next());
		Users[num].setProvince(scanner.next());
		Users[num].setStatus(scanner.next());
		Users[num].setIsolation(scanner.next());
		Users[num].setDate(scanner.next());
		num++;
		System.out.println("添加成功");
	}

	/* 查询某个用户某一天的疫情信息 */
	public static void query() {
		/*
		 * while(true) { System.out.println("请输入2数字继续查询学生信息，返回首页请输入1");
		 * if(scanner.nextInt()==1) { break; }
		 */
		System.out.println("请输入要查询的学生联系电话：");
		String Usersnum = scanner.next();
		System.out.println("请输入要查询的日期：");
		String Usersdate = scanner.next();

		int i;
		for (i = 0; i < num; i++) {
			if (Usersnum.equals(Users[i].getNumber()) && Usersdate.equals(Users[i].getDate())) {
				System.out.println(
						"-----------------------------------------------------------------------------------------");
				System.out.println(
						"姓名             联系电话                      职位              学院         当前所在省      是否有疑似症状      是否处于隔离期                填报日期");
				System.out.println(Users[i].getName() + "\t" + Users[i].getNumber() + "\t" + Users[i].getPosition()
						+ "\t" + Users[i].getXueyuan() + "\t" + Users[i].getProvince() + "\t\t" + Users[i].getStatus()
						+ "\t" + Users[i].getIsolation() + "\t\t" + Users[i].getDate());
				System.out.println(
						"-----------------------------------------------------------------------------------------");
				System.out.println(" ");
				System.out.println(" ");
			} else {
				System.out.println("对不起查无此人");
			}
		}

	}

	/* 修改某个用户某一天的疫情信息 */
	public static void change() {
		System.out.println("请输入要修改的学生联系电话：");
		String Usersnum = scanner.next();
		System.out.println("请输入要修改的日期：");
		String Usersdate = scanner.next();
		for (int i = 0; i < num; i++) {
			if (Usersnum.equals(Users[i].getNumber()) && Usersdate.equals(Users[i].getDate())) {
				System.out.println("请输入该学生的姓名，联系电话，职位，学院，当前所在省，是否有疑似症状，是否处于隔离期");
				Users[num] = new Users();
				Users[num].setName(scanner.next());
				Users[num].setNumber(scanner.next());
				Users[num].setPosition(scanner.next());
				Users[num].setXueyuan(scanner.next());
				Users[num].setProvince(scanner.next());
				Users[num].setStatus(scanner.next());
				Users[num].setIsolation(scanner.next());
				Users[num].setDate(scanner.next());
				break;
			}
			if (num == i)
				System.out.println("对不起查无此人");
		}
	}

	/* 删除查某个用户某一天的疫情信息 */
	public static void delete() {
		System.out.println("请输入要删除信息的用户联系电话：");
		String Usersnum = scanner.next();
		System.out.println("请输入要删除的日期：");
		String Usersdate = scanner.next();

		int i;
		for (i = 0; i < num; i++)
			if (Usersnum.equals(Users[i].getNumber()) && Usersdate.equals(Users[i].getDate()))
				break;
		// if(num==i)System.out.println("对不起查无此人");
		for (; i < num - 1; i++)
			Users[i] = Users[i + 1];
		num--;
		System.out.println("删除完成");
	}

	/* 有疑似症状人员信息 */
	public static void statumessage() {
		int i, j, num1 = 0;
		System.out.println("-----------------------------------------------------------------------------------------");
		System.out.println(
				"姓名             联系电话                      职位              学院         当前所在省      是否有疑似症状      是否处于隔离期                填报日期");
		System.out.println("-----------------------------------------------------------------------------------------");
		for (i = 0; i < num; i++) {
			if (Users[i].getStatus().equals("是")) {

				System.out.println(Users[i].getName() + "\t" + Users[i].getNumber() + "\t" + Users[i].getPosition()
						+ "\t" + Users[i].getXueyuan() + "\t" + Users[i].getProvince() + "\t\t" + Users[i].getStatus()
						+ "\t" + Users[i].getIsolation() + "\t\t" + Users[i].getDate());

				num1++;
			}
		}

		System.out.print("有疫情疑似症状的人数：");
		for (j = 0; j < num1; j++) {
			System.out.print("*");

		}
		System.out.println(" ");
	}

	/* 被隔离人员信息 */
	public static void isolationmessage() {
		int i, j, num2 = 0;
		for (i = 0; i < num; i++) {
			if (Users[i].getIsolation().equals("是")) {
				System.out.println(
						"-----------------------------------------------------------------------------------------");
				System.out.println(
						"姓名             联系电话                      职位              学院         当前所在省      是否有疑似症状      是否处于隔离期                填报日期");
				System.out.println(Users[i].getName() + "\t" + Users[i].getNumber() + "\t" + Users[i].getPosition()
						+ "\t" + Users[i].getXueyuan() + "\t" + Users[i].getProvince() + "\t\t" + Users[i].getStatus()
						+ "\t" + Users[i].getIsolation() + "\t\t" + Users[i].getDate());
				System.out.println(
						"-----------------------------------------------------------------------------------------");
				System.out.println(" ");
				System.out.println(" ");
				num2++;
			}
		}
		System.out.print("被隔离的的人数：");
		for (j = 0; j < num2; j++) {
			System.out.print("*");

		}
		System.out.println(" ");

	}
	/*
	 * 文件读入
	 *
	 * public static void Read(String fileName) {// 此处填写所读文件名
	 * 
	 * String filePath = "src/data2/txt/" + fileName; // 文件地址+文件名 FileReader in
	 * = null; try { in = new FileReader(filePath); } catch
	 * (FileNotFoundException e) { e.printStackTrace(); } BufferedReader br =
	 * new BufferedReader(in);//使用BufferedReader读入并保存 ArrayList<String> list =
	 * new ArrayList<String>(); String s = null;
	 * 
	 * while (true) { try { s = br.readLine(); } catch (IOException e) {
	 * e.printStackTrace(); } list.add(s); if (s == null) break; } }
	 */

}
