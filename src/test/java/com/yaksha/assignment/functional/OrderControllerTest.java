package com.yaksha.assignment.functional;

import static com.yaksha.assignment.utils.TestUtils.businessTestFile;
import static com.yaksha.assignment.utils.TestUtils.currentTest;
import static com.yaksha.assignment.utils.TestUtils.testReport;
import static com.yaksha.assignment.utils.TestUtils.yakshaAssert;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.yaksha.assignment.controller.OrderController;
import com.yaksha.assignment.repository.OrderRepository;
import com.yaksha.assignment.repository.ProductRepository;
import com.yaksha.assignment.service.ProductService;
import com.yaksha.assignment.service.TransactionService;
import com.yaksha.assignment.utils.JavaParserUtils;

import jakarta.persistence.EntityManagerFactory;

@WebMvcTest(OrderController.class)
@AutoConfigureMockMvc
public class OrderControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private TransactionService transactionService;

	@MockBean
	private ProductService productService;

	@MockBean
	private ProductRepository productRepository;

	@MockBean
	private OrderRepository orderRepository;

	@MockBean
	private EntityManagerFactory entityManagerFactory;

	@AfterAll
	public static void afterAll() {
		testReport();
	}

	// Test to check if the 'OrderController' class has @RestController annotation
	@Test
	public void testClassAnnotation() throws Exception {
		String filePath = "src/main/java/com/yaksha/assignment/controller/OrderController.java";
		boolean result1 = JavaParserUtils.checkClassAnnotation(filePath, "RestController");
		boolean result2 = JavaParserUtils.checkClassAnnotation(filePath, "RequestMapping");
		yakshaAssert(currentTest(), result1 && result2, businessTestFile);
	}

	// Test to check if 'placeOrder' method has @PostMapping annotation
	@Test
	public void testPlaceOrderAnnotation() throws Exception {
		String filePath = "src/main/java/com/yaksha/assignment/controller/OrderController.java";
		boolean result = JavaParserUtils.checkMethodAnnotation(filePath, "placeOrder", "PostMapping");
		yakshaAssert(currentTest(), result, businessTestFile);
	}
}
