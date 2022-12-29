package com.e2etests.automation.stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.e2etests.automation.pages.TodoListPage;
import com.e2etests.automation.utils.BasePage;
import com.e2etests.automation.utils.ConfigFileReader;
import com.e2etests.automation.utils.TodoListMethods;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TodoListStepDefinition extends BasePage {

	// pourquoi private
	private TodoListPage todoListPage = new TodoListPage();
	private TodoListMethods todoListMethods = new TodoListMethods();
	public static ConfigFileReader prop = new ConfigFileReader();

	@Given("Je me connecte sur l application todoList")
	public void jeMeConnecteSurLApplicationTodoList() {

		// open url
		todoListPage.openUrl();

		// identification invalide
		todoListMethods.fillText(TodoListPage.adressEmail, prop.getProperties("home.login.invalid"));
		todoListMethods.fillText(TodoListPage.password, prop.getProperties("home.password.invalid"));
		todoListMethods.click(TodoListPage.btnSoumettre);

		// Verifier le message de erreur de identification invalide
		log.error("verification de identification incorrecte");
		todoListMethods.checkErrorMsg(TodoListPage.msgError);
		todoListMethods.getColor(TodoListPage.msgError, "color");

		// clear les champ de l'identification
		TodoListPage.adressEmail.clear();
		TodoListPage.password.clear();

		// identification valide
		todoListMethods.fillText(TodoListPage.adressEmail, prop.getProperties("home.login"));
		todoListMethods.fillText(TodoListPage.password, prop.getProperties("home.password"));
		todoListMethods.click(TodoListPage.btnSoumettre);

		// verifier que la page tache est afichier
		boolean pageTask = todoListMethods.checkInPage(TodoListPage.message);
		Assert.assertTrue(pageTask);
		log.error(TodoListPage.message.getText());
		log.error("**************verification de identification correcte********************");

	}

	@When("Je verifie le bouton Ajouter tache")
	public void jeVerifieLeBoutonAjouterTache() {

		// nomTask exist et descriptionTask null
		todoListMethods.fillText(TodoListPage.nameTask, prop.getProperties("nomTask1.1"));
		todoListMethods.fillText(TodoListPage.descriptionTask, "");
		todoListMethods.click(TodoListPage.addTask);

		boolean pageTask1 = todoListMethods.checkInPage(TodoListPage.message);
		Assert.assertTrue(pageTask1);
		log.error(TodoListPage.message.getText());
		log.error("*******************verification de l'ajout de task nom passante(nameTask est vide  )**************");

		// clear champ nomTask
		TodoListPage.nameTask.clear();

//		// nomTask null et descriptionTask exist
//		todoListMethods.fillText(TodoListPage.nameTask, "");
//		todoListMethods.fillText(TodoListPage.descriptionTask, prop.getProperties("descriptionTask1.1"));
//		todoListMethods.click(TodoListPage.addTask);
//
//		boolean pageTask2 = todoListMethods.checkInPage(TodoListPage.message);
//		Assert.assertTrue(pageTask2);
//		log.error(TodoListPage.message.getText());
//		log.error("***************verification de l'ajout de task nom passante (Description est vide )********************");
//
//		// clear champ descriptionTask
//		TodoListPage.descriptionTask.clear();

		// nomTask exist et descriptionTask exist
		todoListMethods.fillText(TodoListPage.nameTask, prop.getProperties("nomTask1.1"));
		todoListMethods.fillText(TodoListPage.descriptionTask, prop.getProperties("descriptionTask1.1"));
		todoListMethods.click(TodoListPage.addTask);
		
		//verifier que ajout le nom et description est avec suuccé
		String elementTask = todoListMethods.checkElementContain(TodoListPage.listTask);
		Assert.assertTrue(elementTask.contains(prop.getProperties("nomTask1.1")));
		log.error(elementTask);
		log.error("************verification de l'ajout de task passante*******************");

	}

	@And("Je modifie le status d une tache")
	public void jeModifieLeStatusDUneTache() {
		todoListMethods.click(TodoListPage.modifyStatut);
		todoListMethods.checkStatusChanged(TodoListPage.modifyStatut);
	}

	@And("Je supprime une tache")
	public void jeSupprimeUneTache() {
		todoListMethods.click(TodoListPage.btnDelete);
		todoListMethods.checkTaskDeleted(TodoListPage.message);

	}

	@Then("je deconnecte de l application")
	public void jeDeconnecteDeLApplication() {
		todoListMethods.click(TodoListPage.lienDeconnexion);
		todoListMethods.checkOnPageDeconnexion(TodoListPage.labelEmail);

	}

}
