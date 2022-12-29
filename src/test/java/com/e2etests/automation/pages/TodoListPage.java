package com.e2etests.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.e2etests.automation.utils.ConfigFileReader;
import com.e2etests.automation.utils.Setup;

public class TodoListPage {
	public static ConfigFileReader prop = new ConfigFileReader();

	final static String ADDRESS_EMAIL = "//input[@type='email']";
	final static String PASSWORD = "//input[@type='password']";
	final static String BTN_SOUMETTRE = ".btn.btn-primary";
	final static String MESSAGE = "//div[contains(text(),\"Aucune tâche n'a encore été créée.\")]";
	final static String NAME_TASK = "(//input[@type='text'])[1]";
	final static String DESCRIPTION_TASK = "(//input[@type='text'])[2]";
	final static String ADD_TASK = "//button[contains(text(),'Ajouter la tâche')]";
	final static String LIST_TASK = "//body/div[@id='root']/div[1]/div[1]/ul[1]/li[1]/span[1]/b";
	final static String MESSAGE_ERROR = ".alert.alert-danger";
	final static String MODIFY_STATUT = "//body/div[@id='root']/div[1]/div[1]/ul[1]/li[1]/span[2]/div[1]";
	final static String BTN_DELETE = "//body/div[@id='root']/div[1]/div[1]/ul[1]/li[1]/span[1]/a[1]";
	final static String LIEN_TASK = "//a[contains(text(),'Tâches')]";
	final static String LIEN_DECONNEXION = "//a[contains(text(),'Déconnexion')]";
	final static String LABEL_EMAIL = "//label[contains(text(),'Adresse e-mail')]";
	/* @FindBy */
	@FindBy(how = How.XPATH, using = ADDRESS_EMAIL)
	public static WebElement adressEmail;
	@FindBy(how = How.XPATH, using = PASSWORD)
	public static WebElement password;
	@FindBy(how = How.CSS, using = BTN_SOUMETTRE)
	public static WebElement btnSoumettre;
	@FindBy(how = How.XPATH, using = MESSAGE)
	public static WebElement message;
	@FindBy(how = How.XPATH, using = NAME_TASK)
	public static WebElement nameTask;
	@FindBy(how = How.XPATH, using = DESCRIPTION_TASK)
	public static WebElement descriptionTask;
	@FindBy(how = How.XPATH, using = ADD_TASK)
	public static WebElement addTask;
	@FindBy(how = How.XPATH, using = LIST_TASK)
	public static WebElement listTask;
	@FindBy(how = How.CSS, using = MESSAGE_ERROR)
	public static WebElement msgError;
	@FindBy(how = How.XPATH, using = MODIFY_STATUT)
	public static WebElement modifyStatut;
	@FindBy(how = How.XPATH, using = BTN_DELETE)
	public static WebElement btnDelete;
	@FindBy(how = How.XPATH, using = LIEN_TASK)
	public static WebElement lienTask;
	@FindBy(how = How.XPATH, using = LIEN_DECONNEXION)
	public static WebElement lienDeconnexion;
	@FindBy(how = How.XPATH, using = LABEL_EMAIL)
	public static WebElement labelEmail;

	public TodoListPage() {
		PageFactory.initElements(Setup.getDriver(), this);
	}

	/* Methods */

	// get url configs
	public void openUrl() {
		Setup.getDriver().get(prop.getProperties("home.url"));

	}

}
