package es.unileon.ulebank.office;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import es.unileon.ulebank.users.Employee;
import es.unileon.ulebank.service.BankHandler;
import es.unileon.ulebank.client.Client;
import es.unileon.ulebank.exceptions.ClientNotFoundException;
import es.unileon.ulebank.handler.DNIHandler;
import es.unileon.ulebank.handler.Handler;
import es.unileon.ulebank.handler.OfficeHandler;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "offices")
public class Office implements Serializable {

	private static final long serialVersionUID = 1L;

	public static final long MAX_ACCOUNT_NUMBER = 1000000000L - 1;

	private List<Client> clients;

	/**
	 * Id of the office
	 */
	private Handler idOffice;
	/**
	 * Id of the bank
	 */
	private Handler idBank;

	/**
	 * The costs of the local of the office
	 */
	private int localCost;
	/**
	 * The costs of the light, water and gas of the office
	 */
	private int utilitiesCost;
	/**
	 * The expenses in the salaries of the employees
	 */
	private int employeeCost;
	/**
	 * The total expenses or costs of the office
	 */
	private int totalExpenses;
	/**
	 * The total income of the office
	 */
	private int totalIncome;
	/**
	 * The list of employees of this office
	 */
	private ArrayList<Employee> employeeList;

	/**
	 * The list of accounts of this office
	 */
	//

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	/**
	 * The address of the office
	 */
	private String address;
	private int balance;

	/**
	 * Constructor
	 * 
	 * @param idOffice
	 * @param idBank
	 */
	public Office(String idOffice, String idBank) {
		this.clients = new ArrayList<Client>();
		this.idOffice = new OfficeHandler(idOffice);
		this.idBank = new BankHandler(idBank);
		this.employeeList = new ArrayList<Employee>();
		this.balance = 0;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<Client> getClients() {
		return new ArrayList<Client>(this.clients);
	}

	public void setClients(List<Client> clients) {
		this.clients = clients;
	}

	public Handler getIdOffice() {
		return idOffice;
	}

	public void setIdOffice(String idOffice) {
		this.idOffice = new OfficeHandler(idOffice);
	}

	public Handler getIdBank() {
		return idBank;
	}

	public void setIdBank(String idBank) {
		this.idBank = new BankHandler(idBank);
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getLocalCost() {
		return localCost;
	}

	public void setLocalCost(int localCost) {
		this.localCost = localCost;
	}

	public int getUtilitiesCost() {
		return utilitiesCost;
	}

	public void setUtilitiesCost(int utilitiesCost) {
		this.utilitiesCost = utilitiesCost;
	}

	public int getEmployeeCost() {
		return employeeCost;
	}

	public void setEmployeeCost(int employeeCost) {
		this.employeeCost = employeeCost;
	}

	public int getTotalExpenses() {
		return totalExpenses;
	}

	public void setTotalExpenses(int totalExpenses) {
		this.totalExpenses = totalExpenses;
	}

	/**
	 * Returns the income of the office
	 */
	public int getTotalIncome() {
		return totalIncome;
	}

	/**
	 * Sets the total income of the office
	 */
	public void setTotalIncome(int totalIncome) {
		this.totalIncome = totalIncome;
	}

	/**
	 * Returns the balance of the office
	 */
	public int getBalance2() {
		return this.totalIncome - this.totalExpenses;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	/**
	 * Returns the expenses of the office
	 */
	public int getExpenses() {
		return totalExpenses;
	}

	/**
	 * Sets the total expenses of the office
	 */
	public void setExpenses(int localCost, int utilitiesCost, int employeeCost) {

		this.localCost = localCost;
		this.utilitiesCost = utilitiesCost;
		this.employeeCost = employeeCost;

		this.totalExpenses = this.localCost + this.utilitiesCost
				+ this.employeeCost;
	}

	/**
	 * Returns a copy of the list of employees of the office
	 */
	public ArrayList<Employee> getEmployeeList() {
		return new ArrayList<Employee>(employeeList);
	}

	/**
	 * Sets the list of employees of the office
	 */
	public void setEmployeeList(ArrayList<Employee> employeeList) {
		this.employeeList = employeeList;
	}

	/**
	 * Adds an employee to the list of employees
	 */
	public boolean addEmployee(Employee employee) {
		return employeeList.add(employee);
	}

	/**
	 * Deletes an employee to the list of employees
	 *
	 * @param employee
	 * @return
	 */
	public boolean deleteEmployee(Employee employee) {
		return employeeList.remove(employee);
	}

	/**
	 *
	 * @param client
	 * @return
	 */
	public synchronized boolean addClient(Client client) {
		if (client != null) {
			int i = 0;
			boolean found = false;
			while (i < this.clients.size() && !found) {
				found = clients.get(i).getId().compareTo(client.getId()) == 0;
				++i;
			}
			if (!found) {
				return this.clients.add(client);
			}
		}
		return false;
	}

	/**
	 *
	 * @param id
	 * @return
	 */
	public synchronized boolean deleteClient(Handler id) {
		int i = 0;
		boolean found = false;
		while (i < this.clients.size() && !found) {
			if (clients.get(i).getId().compareTo(id) == 0) {
				// TODO perform account liquidation
				clients.remove(i);
				found = true;
			}
			++i;
		}
		return found;
	}

	/**
	 * Busca el cliente cuyo DNI coincida con el recibido
	 * 
	 * @param dni
	 * @return
	 * @throws ClientNotFoundException
	 */
	public Client searchClient(DNIHandler dni) throws ClientNotFoundException {
		// Creamos un iterador para recorrer la lista
		Iterator<Client> iterator = clients.iterator();
		Client client = null;
		boolean found = false;

		// Comprobamos que la lista no este vacia
		if (clients.isEmpty()) {
			throw new NullPointerException("Client list is empty.");
		}

		// Mientras haya clientes recorremos la lista
		while (iterator.hasNext()) {
			// Guardamos el cliente actual
			client = iterator.next();

			// Si el DNI del cliente actual coincide con el indicado salimos del
			// bucle
			if (client.getDni().compareTo(dni) == 0) {
				found = true;
				break;
			}
		}
		// Devolvemos el cliente encontrado
		if (found) {
			return client;
			// si no se encuentra lanzamos una excepcion
		} else {
			throw new ClientNotFoundException("Client not found");
		}
	}

	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("Address: " + address + ";");
		buffer.append("Balance: " + this.getBalance());
		return buffer.toString();
	}

}
