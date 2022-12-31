package study_case_java_dasar_todolist;

import java.util.Iterator;
import java.util.Scanner;

public class AplikasiTodolist {
	
	public static java.util.Scanner scanner = new java.util.Scanner(System.in);
/**
 * membuat model atau representasi data
 */
public static String[] model = new String[10]; 
	
public static void main(String[] args) {
	testViewHapusTodoList();
	
	
}

/**
 * Menampilkan todolist
 */
public static void tampilkanTodoList() {
	for(var i = 0; i < model.length; i++) {
		String todoString = model[i];
		var no = i + 1;
		
		if(todoString != null) {
			System.out.println(no + ". " + todoString);
		}
	}
}

public static void testTampilkanTodoList() {
	model[0] = "Belajar Java Dasar";
	model[1] = "Belajar membuat aplikasi todolist sederhana";
	tampilkanTodoList();
}

/**
 * Menambah todolist
 */
public static void tambahTodoList(String todoString) {
	// cek apakah model penuh
	var isFull = true;
	for(var i = 0; i < model.length; i++) {
		if(model[i] == null) {
			isFull = false;
			break;
		}
	}
	
	if(isFull) {
		var temp = model;
		model = new String[model.length * 2];
		
		for(var i = 0; i < temp.length; i++) {
			model[i] = temp[i];
		}
	}
	
	// tambahkan ke posisi yang data arraynya null
	for(var i = 0; i < model.length; i++) {
		if(model[i] == null) {
			model[i] = todoString;
			break;
		}
	}
}

public static void testTambahTodoList() {
	for(int i = 1; i <= 25; i++) {
		tambahTodoList("Contoh todo ke-" + i);
	}
	
	tampilkanTodoList();
}

/**
 * Menghapus todolist
 */
public static boolean hapusTodoList(Integer nomor) {
	if((nomor -1) >= model.length) {
		return false;
	} else if(model[nomor - 1] == null) {
		return false;
	} else {
		for(int i = (nomor-1); i < model.length; i++) {
			if(i == (model.length -1)) {
				model[i] = null;
			} else {
				model[i] = model[i + 1];
			}
		}
		
		return true;
	}
}

public static void testHapusTodoList() {
	tambahTodoList("satu");
	tambahTodoList("dua");
	tambahTodoList("tiga");
	for(int i = 3; i < 7; i++) {
		tambahTodoList("tambah jadi ke-" + i);
	}
	
	var result = hapusTodoList(10);
	System.out.println(result);
	
	result = hapusTodoList(8);
	System.out.println(result);
	
	result = hapusTodoList(2);
	System.out.println(result);
	
	tampilkanTodoList();
}

public static String input(String info) {
	System.out.print(info + " : ");
	String data = scanner.nextLine();
	return data;
}


public static void testInput() {
	var nama = input("Nama");
	System.out.print("Halo " + nama);
}

public static void viewTampilkanTodoList() {
	while(true) {
		tampilkanTodoList();
		System.out.println();
		System.out.println("TODOLIST");
		System.out.println("OPSI: ");
		System.out.println("1. Tambah");
		System.out.println("2. Hapus");
		System.out.println("x. Keluar");
		
		var input = input("Pilih: ");
		
		if(input.equals("1")) {
			viewTambahTodoList();
		} else if (input.equals("2")) {
			viewHapusTodoList();
		} else if(input.equals("x")) {
			break;
		} else {
			System.out.println("Pilihan tidak dimengerti");
		}
	}
}

public static void testViewShowTodoList() {
	tambahTodoList("satu");
	tambahTodoList("dua");
	tambahTodoList("tiga");
	tambahTodoList("empat");
	tambahTodoList("lima");
	viewTampilkanTodoList();
}

public static void viewTambahTodoList() {
	System.out.println("MANAMBAH TODOLIST");
	
	var todo = input("Todo (x jika Batal)");
	
	if(todo.equals("x")){
		// batal
	} else {
		tambahTodoList(todo);
	}
}

public static void testViewTambahTodoList() {
	tambahTodoList("aku");
	tambahTodoList("kamu");
	
	viewTambahTodoList();
	
	tampilkanTodoList();
	
	
}

public static void viewHapusTodoList() {
	System.out.println("MENGHAPUS TODOLIST");
	
	var number = input("Nomor todo yang dihapus (x jika Batal) ");
	
	if(number.equals("x")) {
		// batal
	} else {
		boolean success = hapusTodoList(Integer.valueOf(number));
		if(!success) {
			System.out.println("gagal mengapus todolist: " + number);
		}
	}
	
}

public static void testViewHapusTodoList() {
	tambahTodoList("aku");
	tambahTodoList("kamu");
	tambahTodoList("kita");
	
	tampilkanTodoList();
	viewTampilkanTodoList();
	
	tampilkanTodoList();
	
}
}












