
package com.test.init;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.transaction.TransactionConfiguration;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 *
 * @author www.ibm.com
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@ContextConfiguration(locations = { "classpath*:applicationContext.xml" })
@TransactionConfiguration(defaultRollback = false)
public abstract class BaseTest extends AbstractTestNGSpringContextTests {

}
