<!-- wp:heading {"level":1} -->
<h1>Test-Driven Development By Example</h1>
<!-- /wp:heading -->
<!-- wp:image {"sizeSlug":"large"} -->
    <figure class="wp-block-image size-large"><img src="https://lh5.googleusercontent.com/aEgiwZOUSW82igvJn5B9RpStCFtVTVS3QfcdSZd1FJtMw0UqYxdJHawtHvHIsFn2m319lgtgURA616JKqiY7oiUcba8G6ACDBPxEpoiy" alt=""/></figure>
<!-- /wp:image -->
<!-- wp:paragraph -->
<p>Within this blog post, I am going to talk about Test-Driven Development (TDD). And I will walk through a concrete example that I hope you will be able to follow and implement yourself.&nbsp;</p>
<!-- /wp:paragraph -->

<!-- wp:paragraph -->
<p>&nbsp;But before I begin with the implementation, let us start with what TDD is. <strong>Test-driven development</strong> (<strong>TDD</strong>) is a <a href="https://en.wikipedia.org/wiki/Software_development_process">software development process</a> that relies on the repetition of a very short development cycle: requirements are turned into very specific <a href="https://en.wikipedia.org/wiki/Test_case">test cases</a>, then the software is improved so that the tests pass. This is opposed to software development that allows software to be added that is not proven to meet requirements.</p>
<!-- /wp:paragraph -->

<!-- wp:paragraph -->
<p> And Kent Beck defines TDD in his Test-Driven Development By Example as follows: Test-driven development is a set of techniques that any software engineer can follow, which encourage simple design and test suites that inspire confidence. </p>
<!-- /wp:paragraph -->

<!-- wp:heading {"level":3} -->
<h3>Concrete Example</h3>
<!-- /wp:heading -->

<!-- wp:paragraph -->
<p>Let’s start with an example. Assume that we have been asked to design a bank account application as an API(<strong>A</strong>pplication <strong>P</strong>rogramming <strong>I</strong>nterface) that should have the following functionalities:&nbsp;</p>
<!-- /wp:paragraph -->

<!-- wp:list {"ordered":true} -->
<ol><li>I would like to be able to withdraw money from my account when there is sufficient balance</li><li>I would like to be able to see the transactions of my account</li></ol>
<!-- /wp:list -->

<!-- wp:heading {"level":4} -->
<h4>The First Requirement</h4>
<!-- /wp:heading -->

<!-- wp:paragraph -->
<p>Let’s start implementing the first requirement which is “I would like to be able to withdraw money from my account”</p>
<!-- /wp:paragraph -->

<!-- wp:paragraph -->
<p> The first step is we write a failing test. But to be able to do that we need to think about the requirements and design of the API. Of course, we don’t need to design all the classes at once. As we will have tests we will be able to refactor easily and confidently. </p>
<!-- /wp:paragraph -->

<!-- wp:paragraph -->
<p>For our API I think we need a BankAccountManager class that exposes the required functions. And we start with its test class which is BankAccountManagerTest. Name convention for test classes is [ClassName]Test.</p>
<!-- /wp:paragraph -->

<!-- wp:paragraph -->
<p> We assume that ‘BankAccountManager’ class has a ‘withdraw’ method that returns ‘OK’ if there is sufficient balance in the account. And there is a ‘balance’ method that returns the balance. </p>
<!-- /wp:paragraph -->

<!-- wp:code -->
<pre class="wp-block-code"><code>package tdd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BankAccountManagerTest {
   @Test
   public void thereIsSufficientBalance() {
       BankAccountManager bankAccountManager = new BankAccountManager(400);
       Assertions.assertEquals("OK", bankAccountManager.withdraw(50), "There is no sufficient balance");
       Assertions.assertEquals(350, bankAccountManager.balance(), "The balance is not 350");
   }
}
</code></pre>
<!-- /wp:code -->

<!-- wp:paragraph -->
<p> If you are using an IDE(<strong>I</strong>ntegrated <strong>D</strong>evelopment <strong>E</strong>nvironment) that will help you to create required classes and methods from the test. What I am using as IDE for this demonstration is IntelliJ. </p>
<!-- /wp:paragraph -->

<!-- wp:image {"sizeSlug":"large"} -->
<figure class="wp-block-image size-large"><img src="https://lh6.googleusercontent.com/y4FjVK_ImbkI0Q5X48LN-e6umMJgigk0e2DmoOam7IYlq_362i-o54FGfWRbtdvMuvQz_ypC1s4EWQKyFKQ62miuwp4j8vR_p9KnDKG8_DfGWM33PdLr8vi3f0YP62S4_ol87VSF" alt=""/></figure>
<!-- /wp:image -->

<!-- wp:paragraph -->
<p> Once we create the BanckAccountManager class by selecting “Create class ‘BanckAccountManager’“ now we need to create the ‘withdraw’ method.</p>
<!-- /wp:paragraph -->

<!-- wp:image {"sizeSlug":"large"} -->
<figure class="wp-block-image size-large"><img src="https://lh3.googleusercontent.com/ZzBIOTPDEHCHUNyQ2iHmEdBz5dli6Khhx27DC8W5l-GeoUcPzqzSvl9t_a4EvcoPPr1acs01Rn1-cI2Qxw1UUiVw6eJEXnIacYtKxFWwKLHA3yiypZw8Up0EdAXYAkYIpxlTb4Ja" alt=""/></figure>
<!-- /wp:image -->

<!-- wp:paragraph -->
<p> BankAccountManager class has been created automatically by the IDE as follows. Now we have a test method and actual method which compile.  </p>
<!-- /wp:paragraph -->

<!-- wp:code -->
<pre class="wp-block-code"><code>package tdd;

public class BankAccountManager {
   public BankAccountManager(int balance) {
   }

   public Object withdraw(int amount) {
       return null;
   }

   public int balance() {
       return 0;
   }
}</code></pre>
<!-- /wp:code -->

<!-- wp:paragraph -->
<p>Let’s run the first test to see if it fails then we will make it pass. To run the test method we just click the play button next to it.</p>
<!-- /wp:paragraph -->

<!-- wp:image {"sizeSlug":"large"} -->
<figure class="wp-block-image size-large"><img src="https://lh6.googleusercontent.com/d6gKVilxeCII2hIsUXtlyCjxKhBNtNKOlqy3PvugO2Y1SUdHlTOKtp-JEHwb_5y3kMazRLq7GiobcG9NmePLkiG8sezjiYOaIOLoULjjCy1NaxW85_kndbqn-RqqblUjt9ZGCxlS" alt=""/></figure>
<!-- /wp:image -->

<!-- wp:image {"sizeSlug":"large"} -->
<figure class="wp-block-image size-large"><img src="https://lh5.googleusercontent.com/5XCVj_VXmqtoPqeS4BuxPyLftFmeTEKcS3E12zwSnmxYRzb5yBxNzeRUppS_doDn5Wp9JklsmfdpUzlNBr1UeyrA5pmfovkYl4dq6ElDzKM7a9oseoh8mdkHil1ZZa-LzKxou0Oh" alt=""/><figcaption>The first test is failing as we expected.</figcaption></figure>
<!-- /wp:image -->

<!-- wp:paragraph -->
<p> So it is time to make it green! We just change the return values of the two methods to make the test green. </p>
<!-- /wp:paragraph -->

<!-- wp:code -->
<pre class="wp-block-code"><code>package tdd;

public class BankAccountManager {
   public BankAccountManager(int balance) {
   }

   public Object withdraw(int amount) {
       return "OK";
   }

   public int balance() {
       return 350;
   }
}</code></pre>
<!-- /wp:code -->

<!-- wp:paragraph -->
<p> Obviously this is not what we want. Withdraw and balance methods should not return hardcoded values. So let’s add one more failing test. </p>
<!-- /wp:paragraph -->

<!-- wp:code -->
<pre class="wp-block-code"><code>package tdd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BankAccountManagerTest {

   @Test
   public void thereIsSufficientBalance() {
       BankAccountManager bankAccountManager = new BankAccountManager(400);
       Assertions.assertEquals("OK", bankAccountManager.withdraw(50), "There is no sufficient balance");
       Assertions.assertEquals(350, bankAccountManager.balance(), "The balance is not 350");
   }

   @Test
   public void thereIsNoSufficientBalance() {
       BankAccountManager bankAccountManager = new BankAccountManager(400);
       Assertions.assertEquals("NO_SUFFICIENT_BALANCE", bankAccountManager.withdraw(450), "There is sufficient balance");
   }
}</code></pre>
<!-- /wp:code -->

<!-- wp:paragraph -->
<p> We just make the following changes to make both tests green: </p>
<!-- /wp:paragraph -->

<!-- wp:code -->
<pre class="wp-block-code"><code>package tdd;

public class BankAccountManager {
   private int balance;
   public BankAccountManager(int balance) {
       this.balance = balance;
   }

   public Object withdraw(int amount) {
       if (amount &lt; balance) {
           balance = balance - amount;
           return "OK";
       }
       return "NO_SUFFICIENT_BALANCE";
   }

   public int balance() {
       return balance;
   }
}
</code></pre>
<!-- /wp:code -->

<!-- wp:paragraph -->
<p> Now both tests are green. But I think we missed one more case which is withdrawing all balance. So let’s add a test for it as well.  </p>
<!-- /wp:paragraph -->

<!-- wp:code -->
<pre class="wp-block-code"><code>   @Test
   public void thereIsSufficientBalance() {
       BankAccountManager bankAccountManager = new BankAccountManager(400);
       Assertions.assertEquals("OK", bankAccountManager.withdraw(50), "There is no sufficient balance");
       Assertions.assertEquals(350, bankAccountManager.balance(), "The balance is not 350");

       Assertions.assertEquals("OK", bankAccountManager.withdraw(350), "There is no sufficient balance");
       Assertions.assertEquals(0, bankAccountManager.balance(), "The balance is not 0");
   }</code></pre>
<!-- /wp:code -->

<!-- wp:paragraph -->
<p> We changed if statement in the 'withdraw' method to make test green: </p>
<!-- /wp:paragraph -->

<!-- wp:code -->
<pre class="wp-block-code"><code>public Object withdraw(int amount) {
   if (amount &lt;= balance) {
       balance = balance - amount;
       return "OK";
   }
   return "NO_SUFFICIENT_BALANCE";
}</code></pre>
<!-- /wp:code -->

<!-- wp:heading {"level":4} -->
<h4>The Second Requirement</h4>
<!-- /wp:heading -->

<!-- wp:paragraph -->
<p>It is time to start implementing the second requirement which is “I would like to be able to see the transactions of my account”</p>
<!-- /wp:paragraph -->

<!-- wp:paragraph -->
<p>For this, we add the following test and assume that BankAccountManager will have a ‘transactions’ method that returns the transactions of the account as a collection.</p>
<!-- /wp:paragraph -->

<!-- wp:code -->
<pre class="wp-block-code"><code>@Test
public void transactions() {
   BankAccountManager bankAccountManager = new BankAccountManager(400);
   Assertions.assertEquals(Collections.EMPTY_LIST, bankAccountManager.transactions(), "The transactions are not empty");
}</code></pre>
<!-- /wp:code -->

<!-- wp:paragraph -->
<p> Then we created the ‘transactions’ method via Intellij: </p>
<!-- /wp:paragraph -->

<!-- wp:code -->
<pre class="wp-block-code"><code>public Object transactions() {
   return null;
}</code></pre>
<!-- /wp:code -->

<!-- wp:paragraph -->
<p> Of course, the test is failing! To make it green we do this: </p>
<!-- /wp:paragraph -->

<!-- wp:code -->
<pre class="wp-block-code"><code>public Object transactions() {
   return Collections.EMPTY_LIST;
}</code></pre>
<!-- /wp:code -->

<!-- wp:paragraph -->
<p> Now we need another failing test which is: </p>
<!-- /wp:paragraph -->

<!-- wp:code -->
<pre class="wp-block-code"><code>@Test
public void transactions() {
   Assertions.assertEquals(Collections.EMPTY_LIST, bankAccountManager.transactions(), "The transactions are not empty");

   bankAccountManager.withdraw(10);
   bankAccountManager.withdraw(15);
   bankAccountManager.withdraw(20);
   Assertions.assertEquals(Arrays.asList(10, 15, 20), bankAccountManager.transactions());
}</code></pre>
<!-- /wp:code -->

<!-- wp:paragraph -->
<p>And it is time to implement the ‘transactions’ logic:</p>
<!-- /wp:paragraph -->

<!-- wp:code -->
<pre class="wp-block-code"><code>public class BankAccountManager {
   private int balance;
   private List&lt;Integer> transactions = new ArrayList&lt;Integer>();
   public BankAccountManager(int balance) {
       this.balance = balance;
   }

   public Object withdraw(int amount) {
       if (amount &lt;= balance) {
           balance = balance - amount;
           transactions.add(amount);
           return "OK";
       }
       return "NO_SUFFICIENT_BALANCE";
   }

   public int balance() {
       return balance;
   }

   public Object transactions() {
       return transactions;
   }
}</code></pre>
<!-- /wp:code -->

<!-- wp:heading {"level":3} -->
<h3>Refactoring</h3>
<!-- /wp:heading -->

<!-- wp:paragraph -->
<p>Now we have implemented all the requirements. But if you noticed that there is some code duplication in tests. Can we refactor them? Of course we can do that confidently as all code is covered by the tests. Let’s do that then!</p>
<!-- /wp:paragraph -->

<!-- wp:paragraph -->
<p>Creation of BankAccountManager is moved to the ‘setUp’ method that will be run before each test.</p>
<!-- /wp:paragraph -->

<!-- wp:code -->
<pre class="wp-block-code"><code>public class BankAccountManagerTest {
   BankAccountManager bankAccountManager;

   @BeforeEach
   public void setUp() {
       bankAccountManager = new BankAccountManager(400);
   }

   @Test
   public void thereIsSufficientBalance() {
       Assertions.assertEquals("OK", bankAccountManager.withdraw(50), "There is no sufficient balance");
       Assertions.assertEquals(350, bankAccountManager.balance(), "The balance is not 350");

       Assertions.assertEquals("OK", bankAccountManager.withdraw(350), "There is no sufficient balance");
       Assertions.assertEquals(0, bankAccountManager.balance(), "The balance is not 0");
   }

   @Test
   public void thereIsNoSufficientBalance() {
       Assertions.assertEquals("NO_SUFFICIENT_BALANCE", bankAccountManager.withdraw(450), "There is sufficient balance");
   }

   @Test
   public void transactions() {
       Assertions.assertEquals(Collections.EMPTY_LIST, bankAccountManager.transactions(), "The transactions are not empty");

       bankAccountManager.withdraw(10);
       bankAccountManager.withdraw(15);
       bankAccountManager.withdraw(20);
       Assertions.assertEquals(Arrays.asList(10, 15, 20), bankAccountManager.transactions());
   }
}</code></pre>
<!-- /wp:code -->
<!-- wp:heading {"level":3} -->
<h3>Final Thoughts</h3>
<!-- /wp:heading -->

<!-- wp:paragraph -->
<p>  That’s the end of the exercise. I hope you enjoyed it and were able to learn something new. The most important take-away from this exercise is to take small steps!  The source code of this project can be found on my <a href="https://github.com/fatihtokus/tddByExample">github page</a>. </p>
<!-- /wp:paragraph -->