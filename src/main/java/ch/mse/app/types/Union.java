package ch.mse.app.types;

import java.io.Closeable;
import java.io.DataInput;
import java.io.IOException;

public class Union {

	<T extends DataInput & Closeable> String readData(T source) {
		try (T s = source) {
			return s.readUTF();
		} catch (IOException e) {
			return null;
		}
	}

}
