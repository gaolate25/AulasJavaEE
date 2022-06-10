package br.com.senai.gustavogomes.application.config;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.annotation.FacesConfig;
import javax.faces.annotation.FacesConfig.Version;

@FacesConfig(version = Version.JSF_2_3) //é responsável por descrever os elementos e elementos que compõem o projeto, tais como as regras de navegação, os beans gerenciados, configurações de localização,
@ApplicationScoped //uma instância será criada apenas uma vez durante todo o sistema
public class Config {

}
