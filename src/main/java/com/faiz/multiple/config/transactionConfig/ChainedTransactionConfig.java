package com.faiz.multiple.config.transactionConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.transaction.ChainedTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class ChainedTransactionConfig {

	@Autowired
	@Qualifier("userTransactionManager")
	private PlatformTransactionManager userTransacManager;

	@Autowired
	@Qualifier("bookTransactionManager")
	private PlatformTransactionManager bookTransacManager;

	@Bean(name = "chainedTransactionManager")
	public ChainedTransactionManager chainedTransactionManager() {
		return new ChainedTransactionManager(userTransacManager, bookTransacManager);
	}

}
