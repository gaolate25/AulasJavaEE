package br.com.senai.gustavogomes.application.config;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.annotation.FacesConfig;
import javax.faces.annotation.FacesConfig.Version;

@FacesConfig(version = Version.JSF_2_3) //� respons�vel por descrever os elementos e elementos que comp�em o projeto, tais como as regras de navega��o, os beans gerenciados, configura��es de localiza��o,
@ApplicationScoped //uma inst�ncia ser� criada apenas uma vez durante todo o sistema
public class Config {

}
