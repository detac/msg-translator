package com.msg.translator;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.msg.translator.dao.DaoTestSuite;
import com.msg.translator.service.ServiceTestSuite;

@RunWith(Suite.class)
@Suite.SuiteClasses({ DaoTestSuite.class, ServiceTestSuite.class })
public class TestSuite {
	// nothing
}
