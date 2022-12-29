package com.e2etests.automation.utils;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TodoListMethods extends BasePage {

	// fill Email & motPass & nomTask & description
	public void fillText(WebElement element, String value) {
		element.sendKeys(value);
	}

	// click btn_soumettre & btn_ajout & btn_modificateur satut
	public void click(WebElement element) {
		element.click();
	}

	// verifier que la page est affichier
	public Boolean checkInPage(WebElement pg) {
		Boolean isPageDisplayed = pg.isDisplayed();
		return isPageDisplayed;
	}

	public String checkElementContain(WebElement element) {

		String elementAjout = element.getText();
		return elementAjout;
	}

	// Message d' erreur de l'identification incorrecte
	public void checkErrorMsg(WebElement element) {
		String msg = element.getText();
		System.out.println("********************" + msg + "****************");
		Assert.assertEquals(msg, "Désolé, les identifiants sont incorrects.");
	}

	// Color de message d'error de l'identification incorrecte
	public void getColor(WebElement element, String value) {
		String color = element.getCssValue(value);
		System.out.println("The color is:" + color);

		String[] hexValue = color.replace("rgba(", "").replace(")", "").split(",");
		System.out.println("The hexValue is:" + hexValue);

		int hexValue1 = Integer.parseInt(hexValue[0]);
		hexValue[1] = hexValue[1].trim();
		System.out.println("The hexValue1 is:" + hexValue1);

		int hexValue2 = Integer.parseInt(hexValue[1]);
		hexValue[2] = hexValue[2].trim();
		System.out.println("The hexValue2 is:" + hexValue2);

		int hexValue3 = Integer.parseInt(hexValue[2]);
		System.out.println("The hexValue3 is:" + hexValue3);

		String actualColor = String.format("#%02x%02x%02x", hexValue1, hexValue2, hexValue3);
		System.out.println("The actualColor is:" + actualColor);

		Assert.assertEquals("#721c24", actualColor);
		System.out.println("The color is:" + actualColor);
	}

	// verification changement statut
	public void checkStatusChanged(WebElement element) {
		String text = element.getText();
		log.error(text);
		if (text == ("Complétée")) {
			log.error("Verification successfull - statut is changed");
		} else {
			log.error("Verification failed - statut is not changed");
		}
	}

	public void checkTaskDeleted(WebElement element) {
		String text = element.getText();
		log.error(text);
//		if (Assert.isNonEmpty(text)) {
//			System.out.println("Verification successfully - The list is not empty ");
//		} else {
//			System.out.println("Verification failed - an incorrect list is emty ");
//		}
	}

	public void checkOnPageDeconnexion(WebElement element) {
		String msg = element.getText();
		System.out.println("********************" + msg + "****************");
		Assert.assertEquals(msg, "Adresse e-mail");
		
	}

}
