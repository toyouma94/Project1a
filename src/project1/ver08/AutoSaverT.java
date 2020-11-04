package project1.ver08;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.HashSet;

public class AutoSaverT extends Thread{
	
	PhoneBookManager phoneBookManager;
	public AutoSaverT(PhoneBookManager phoneBookManager) {
		this.phoneBookManager  = phoneBookManager;
	}

	@Override
	public void run() {
		while(true) {
			try {
				phoneBookManager.autoSave();
				sleep(5000);
				System.out.println("5초마다 자동저장!!");
				System.out.println("printf.txt 가 생성되었습니다");
			}
			catch(InterruptedException e) {
				return;
			} 
			catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

