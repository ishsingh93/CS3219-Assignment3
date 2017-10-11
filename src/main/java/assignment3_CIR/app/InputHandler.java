package assignment3_CIR.app;

public class InputHandler {
	
	private static final String FILEOP = "count";
	private static final String DATAOP = "select";
	
	private Input inputObj;
	
	public InputHandler(Input inputObj) {
		this.setInputObj(inputObj);
		assignToManager();
	}

	private void assignToManager() {
		String command = inputObj.getQueryCommand();
		switch (command) {
		case FILEOP :
			FileObj fileObj = new FileObj(inputObj);
			break;
		case DATAOP :
			DataObj dataObj = new DataObj(inputObj);
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
