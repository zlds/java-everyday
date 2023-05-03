package org.example.gof.facadepattern;

/**
 * @author: hanchaowei
 * @date 2023/5/3
 * @description: 作为门面类
 */

public class Computer {
	private CPU cpu;
	private Memory memory;
	private HardDrive hardDrive;

	public Computer() {
		this.cpu = new CPU();
		this.memory = new Memory();
		this.hardDrive = new HardDrive();
	}

	public void compute() {
		hardDrive.read();
		memory.load();
		cpu.execute();
	}
}
