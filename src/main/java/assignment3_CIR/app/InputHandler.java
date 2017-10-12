package assignment3_CIR.app;

import java.io.IOException;

public class InputHandler {
	
	private static final String FILEOP = "count";
	private static final String DATAOP = "select";
	
	private Input inputObj;
	
	public InputHandler(Input inputObj) throws IOException {
		this.setInputObj(inputObj);
		assignToManager();
	}

	private void assignToManager() throws IOException {
		String command = inputObj.getQueryCommand();
		switch (command) {
		case FILEOP :
			DataManager dm = new DataManager(inputObj);
			break;
		case DATAOP :
			break;
		default :
			break;
		}
		
	}

	public Input getInputObj() {
		return inputObj;
	}

	public void setInputObj(Input inputObj) {
		this.inputObj = inputObj;
	}
}
