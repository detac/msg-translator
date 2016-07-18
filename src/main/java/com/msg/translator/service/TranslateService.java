package com.msg.translator.service;

public class TranslateService {

  private GlossaryService glossary;

  public TranslateService() {
    this.glossary = new GlossaryService();
    this.glossary.init();
  }

  public String translate(String formula) {
    StringBuilder translated = new StringBuilder();
    // Ovde bi mozda trebalo da primenis neki interpret pattern, ali ti za to nemas vremena;
    // moj savet ti je da imas state u kome se nalazis, a u njega ulazis, tako sto naidjes na //naziv tipa u formulu;
    // zatim za taj state, primenjujes dati tip, pa prevodis formulu za taj tip pozivom sledeceg methoda.
    // glossary.translate(dati_tip, data_formula); i sve to guras u builder translated;
    return translated.toString();
  }
}
