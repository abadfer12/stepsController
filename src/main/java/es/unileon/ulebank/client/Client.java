/* Application developed for AW subject, belonging to passive operations
 group.*/

package es.unileon.ulebank.client;

import es.unileon.ulebank.handler.Handler;

public class Client {

	/**
	 * Identifier of the client
	 */
	private Handler id;

	/**
	 * Client age
	 */
	private int age;

	/**
	 * Constructor of client. Receive the id and initilize the list of accounts
	 * 
	 * @param clientHandler
	 */
	public Client(Handler clientHandler) {
		this.id = clientHandler;
	}

	public Client(Handler clientHandler, int age) {
		this.id = clientHandler;
		this.age = age;
	}

	/**
	 * @return id of the client
	 */
	public Handler getId() {
		return id;
	}

	public Handler getDni() {
		return id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}
