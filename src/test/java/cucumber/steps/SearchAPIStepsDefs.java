package cucumber.steps;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import models.HttpStatusCode;
import models.ResponseStructure;
import models.SearchResponse;
import models.parameters.ParameterBuilder;
import models.parameters.Parameters;
import models.qualifiers.QualifiersBuilder;
import models.qualifiers.QueryQualifier;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import questions.*;
import questions.responseNonSuccessful.GivenResponse;
import questions.responseSuccessful.ListedItems;
import questions.responseSuccessful.ResponseFields;
import tasks.Get;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.lessThanOrEqualTo;

public class SearchAPIStepsDefs {
    private Actor unauthorizedUser;
    private String baseURI;
    private String resourceURI;

    @Before
    public void setUp() {
        OnStage.setTheStage(new OnlineCast());
        unauthorizedUser = theActorCalled("Unauthorized User");
        baseURI = "https://api.github.com/";
        RestAssured.baseURI = baseURI;
    }

    @Given("^user can make requests to \"([^\"]*)\"$")
    public void userCanMakeRequestsTo(String resourceURI) {
        this.resourceURI = resourceURI;
        unauthorizedUser.can(CallAnApi.at(baseURI.concat(resourceURI)));
    }

    @When("^user sends request filling parameter q with values \"([^\"]*)\"$")
    public void userSendsRequestFillingParameterQWithValues(String author) {
        QueryQualifier query = QualifiersBuilder.startQueuingQualifiers()
                .withAuthor(author)
                .build();
        Parameters parameters = ParameterBuilder.parameters()
                .withQ(query.getList())
                .build();

        unauthorizedUser.attemptsTo(Get.resource(resourceURI, parameters.getParameters()));
    }

    @When("^user sends request filling parameter q with values for author: \"([^\"]*)\" and sort: \"([^\"]*)\"$")
    public void userSendsRequestFillingParameterQWithValues(String author, String sortType) {
        QueryQualifier query = QualifiersBuilder.startQueuingQualifiers()
                .withAuthor(author)
                .build();
        Parameters parameters = ParameterBuilder.parameters()
                .withQ(query.getList())
                .withSort(sortType)
                .build();

        unauthorizedUser.attemptsTo(Get.resource(resourceURI, parameters.getParameters()));
    }

    @When("^user sends request filling parameter q with values for author: \"([^\"]*)\", per_page: \"([^\"]*)\" and page: \"([^\"]*)\"$")
    public void userSendsRequestFillingParameterQWithValuesForAuthorPerPageAndPage(String author, String per_page, String page) {
        QueryQualifier query = QualifiersBuilder.startQueuingQualifiers()
                .withAuthor(author)
                .build();
        Parameters parameters = ParameterBuilder.parameters()
                .withQ(query.getList())
                .withResultsPerPage(per_page)
                .onPage(page)
                .build();

        unauthorizedUser.attemptsTo(Get.resource(resourceURI, parameters.getParameters()));
    }

    @When("^user sends request filling parameter q with values for author: \"([^\"]*)\", sort: \"([^\"]*)\" and per_page: \"([^\"]*)\"$")
    public void userSendsRequestFillingParameterQWithValuesForAuthorSortAndPerPage(String author, String sort, String per_page) {
        QueryQualifier query = QualifiersBuilder.startQueuingQualifiers()
                .withAuthor(author)
                .build();
        Parameters parameters = ParameterBuilder.parameters()
                .withQ(query.getList())
                .withSort(sort)
                .withResultsPerPage(per_page)
                .build();
        unauthorizedUser.attemptsTo(Get.resource(resourceURI, parameters.getParameters()));
    }

    @Then("^service returns a list of repositories$")
    public void serviceReturnsAListOfRepositories() {
        unauthorizedUser.should(seeThat(StatusCode.is(), equalTo(HttpStatusCode.SUCCESS.code())));
        ResponseStructure response = new SearchResponse();
        unauthorizedUser.should(seeThat(ResponseFields.areCorrect(response)));
    }

    @Then("^service returns repo not found or not accessible$")
    public void serviceReturnsRepoNotFoundOrNotAccessible() {
        unauthorizedUser.should(seeThat(StatusCode.is(), equalTo(HttpStatusCode.UNPROCESSABLE_ENTITY.code())));
        unauthorizedUser.should(seeThat(GivenResponse.message(), equalTo("Validation Failed")));
        unauthorizedUser.should(seeThat(GivenResponse.errorMessage(), equalTo("The listed users and repositories cannot be searched either because the resources do not exist or you do not have permission to view them.")));
    }

    @Then("^service returns a list of repositories showing at least \"([^\"]*)\" items$")
    public void serviceReturnsAListOfRepositoriesShowingAtLeastItems(String per_page) {
        unauthorizedUser.should(seeThat(StatusCode.is(), equalTo(HttpStatusCode.SUCCESS.code())));
        ResponseStructure response = new SearchResponse();
        unauthorizedUser.should(seeThat(ListedItems.count(response), lessThanOrEqualTo(Integer.parseInt(per_page))));
        unauthorizedUser.should(seeThat(ResponseFields.areCorrect(response)));
    }
}
