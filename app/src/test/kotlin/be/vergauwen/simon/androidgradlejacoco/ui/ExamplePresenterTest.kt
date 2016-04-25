package be.vergauwen.simon.androidgradlejacoco.ui

import be.vergauwen.simon.androidgradlejacoco.core.rx.MockRxUtil
import be.vergauwen.simon.androidgradlejacoco.core.service.MockGithubAPI
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class ExamplePresenterTest {

  lateinit var presenter: ExamplePresenter
  lateinit var view: MockExampleView
  lateinit var githubAPI : MockGithubAPI

  @Before
  fun setUp() {
    githubAPI = MockGithubAPI()
    presenter = ExamplePresenter(githubAPI, MockRxUtil())
    view = MockExampleView()
  }

  @Test
  fun preConditions() {
    assertNotNull(presenter)
    assertFalse(view.printedRepo)
  }

  @Test
  fun testAssertViewAttached() {
    presenter.attachView(view)
    assertNotNull(presenter.getView())
  }

  @Test
  fun testRepoPrinted() {
    presenter.attachView(view)
    assertFalse(view.printedRepo)
    presenter.getRepos()
    assertTrue(view.printedRepo)
  }

  @Test
  fun testRetrofitError() {
    presenter.attachView(view)
    assertFalse(view.errorShown)
    githubAPI.throwError = true
    presenter.getRepos()
    assertTrue(view.errorShown)
  }
}

