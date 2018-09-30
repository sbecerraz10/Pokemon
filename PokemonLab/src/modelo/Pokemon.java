package modelo;

import java.io.Serializable;
import java.net.URL;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
/**
 * Clase Pokemon
 * @author Sebastian Becerra Z. A00352804
 * @version sep-18-2018
 */

public class Pokemon implements Serializable{
	
	
	//Atributos
	private String name;
	private URL linkimage;
	private URL linkgif;
	
	
	


	
	/**
	 * Metodo Contructor
	 * @param name: name of the Pokemon
	 * @param linkimage: link of the image
	 * @param linkgif:link of the gif
	 */
	public Pokemon(String name, URL linkimage, URL linkgif) {
		this.name = name;
		this.linkimage = linkimage;
		this.linkgif = linkgif;
	}
	
	



	

	/***
	 * Method getName
	 * @return name: Pokemon's name
	 */
	public String getName() {
		return name;
	}



	/**
	 * Method setName
	 * @param name: Pokemon's name
	 */
	public void setName(String name) {
		this.name = name;
	}



	/**
	 * Method getLinkImage
	 * @return linkimage: link image
	 */
	public URL getLinkimage() {
		return linkimage;
	}



	/**
	 * Method SetLinkImage
	 * @param linkimage:link image
	 */
	public void setLinkimage(URL linkimage) {
		this.linkimage = linkimage;
	}



	/**
	 * Method getLinkgif
	 * @return linkgif: link gif
	 */
	public URL getLinkgif() {
		return linkgif;
	}



	/**
	 * Method setLinkgif
	 * @param linkgif: link gif
	 */
	public void setLinkgif(URL linkgif) {
		this.linkgif = linkgif;
	}
	
	
	
	
}
