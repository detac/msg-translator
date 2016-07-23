package com.msg.translator.service;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({ GlossaryServiceTest.class, TranslateServiceTest.class, NonTranslatedTermsServiceTest.class })
public class ServiceTestSuite {
	// nothing
}
