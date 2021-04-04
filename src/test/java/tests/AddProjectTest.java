package tests;

import baseEntities.BaseTest;
import enums.ProjectType;
import models.Project;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AddProjectPage;
import pages.DashboardPage;
import pages.LoginPage;
import pages.ProjectsPage;
import steps.LoginSteps;
import steps.ProjectSteps;

public class AddProjectTest extends BaseTest {

    @Test
    public void AddNewProjectTest1(){

       LoginSteps loginSteps = new LoginSteps(browsersService);
        AddProjectPage addProjectPage = loginSteps
                .loginWithCorrectCredentialsOnAddProjectPage("atrostyanko+0401@gmail.com","QqtRK9elseEfAk6ilYcJ");

        String projectName = "VBilevich_1";

        Project project = new Project();
        project.setName(projectName);
        project.setAnnouncement("Test Project Definition");
        project.setShowAnnouncement(true);
        project.setType(ProjectType.SINGLE_FOR_ALL_CASES);

        ProjectSteps projectSteps = new ProjectSteps(browsersService);
        ProjectsPage projectsPage = projectSteps.fillAddProjectForm(project, addProjectPage);

        Assert.assertEquals(projectsPage.getSuccessLabelText(),"Successfully added the new project.");

        Assert.assertEquals(projectsPage.getAddProjectName1(),projectName);

    }

   @Test
    public void AddNewProjectTest2(){

       LoginSteps loginSteps = new LoginSteps(browsersService);
        AddProjectPage addProjectPage = loginSteps
                .loginWithCorrectCredentialsOnAddProjectPage("atrostyanko+0401@gmail.com","QqtRK9elseEfAk6ilYcJ");

        String projectName = "VBilevich_2";

        Project project = new Project();
        project.setName(projectName);
        project.setAnnouncement("Test Project Definition");
        project.setShowAnnouncement(false);
        project.setType(ProjectType.SINGLE_WITH_BASELINE);

        ProjectSteps projectSteps = new ProjectSteps(browsersService);
        ProjectsPage projectsPage = projectSteps.fillAddProjectForm(project, addProjectPage);

        Assert.assertEquals(projectsPage.getSuccessLabelText(),"Successfully added the new project.");

        Assert.assertEquals(projectsPage.getAddProjectName2(),projectName);

    }

   @Test
    public void AddNewProjectTest3(){

       LoginSteps loginSteps = new LoginSteps(browsersService);
        AddProjectPage addProjectPage = loginSteps
                .loginWithCorrectCredentialsOnAddProjectPage("atrostyanko+0401@gmail.com","QqtRK9elseEfAk6ilYcJ");

        String projectName = "VBilevich_3";

        Project project = new Project();
        project.setName(projectName);
        project.setAnnouncement("Test Project Definition");
        project.setShowAnnouncement(true);
        project.setType(ProjectType.MULTIPLE);

        ProjectSteps projectSteps = new ProjectSteps(browsersService);
        ProjectsPage projectsPage = projectSteps.fillAddProjectForm(project, addProjectPage);

        Assert.assertEquals(projectsPage.getSuccessLabelText(),"Successfully added the new project.");

        Assert.assertEquals(projectsPage.getAddProjectName3(),projectName);

    }
}
