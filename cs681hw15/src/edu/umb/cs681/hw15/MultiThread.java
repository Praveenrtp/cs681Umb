package edu.umb.cs681.hw15;

public class MultiThread {

	public static void main(String[] args) {

		AdmissionControl admission = new AdmissionControl();
		EntranceHandler entrance = new EntranceHandler(admission);
		ExitHandler exitHandler = new ExitHandler(admission);
		AdmissionMonitor monitor = new AdmissionMonitor(admission);

		Thread tEntrance = new Thread(entrance);
		Thread tExit = new Thread(exitHandler);
		Thread tMonitor = new Thread(monitor);

		tEntrance.start();
		tExit.start();
		tMonitor.start();

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		entrance.setDone();
		exitHandler.setDone();
		monitor.setDone();

		tEntrance.interrupt();
		tExit.interrupt();
		tMonitor.interrupt();

		try {
			tEntrance.join();
			tExit.join();
			tMonitor.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}