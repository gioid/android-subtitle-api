package it.neunet.subtitle.usf;

public class Author {
	private String email, name, url, task;

	/**
	 * 
	 */
	public Author() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param email
	 * @param name
	 * @param url
	 * @param task
	 */
	public Author(String email, String name, String url, String task) {
		super();
		this.email = email;
		this.name = name;
		this.url = url;
		this.task = task;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * @return the task
	 */
	public String getTask() {
		return task;
	}

	/**
	 * @param task the task to set
	 */
	public void setTask(String task) {
		this.task = task;
	}
	
	@Override
	public String toString(){
		return "Author -> \n" +
				"\t Name: " + name + "\n" +
				"\t Email: " + email + "\n" + 
				"\t Task: " + task + "\n" +
				"\t Url: " + url + "\n";
	}
}
