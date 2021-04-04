package steps;

import baseEntities.BaseStep;
import core.BrowsersService;
import enums.ProjectType;
import models.Project;
import pages.AddProjectPage;
import pages.ProjectsPage;

public class ProjectSteps extends BaseStep {

    public ProjectSteps(BrowsersService browsersService) {
        super(browsersService);
    }

    public void AddProject(Project project) {
        System.out.println(project.getName());
        System.out.println(project.getAnnouncement());
        System.out.println(project.isShowAnnouncement());
        System.out.println(project.getType());
    }

    public ProjectsPage fillAddProjectForm(Project project, AddProjectPage addProjectPage) {
        addProjectPage.getNameInput().sendKeys(project.getName());
        addProjectPage.getAnnouncementInput().sendKeys(project.getAnnouncement());

        if (project.isShowAnnouncement()) {
            addProjectPage.getShowAnnouncement().click();
        }

        switch (project.getType()){
            case SINGLE_FOR_ALL_CASES:
                addProjectPage.getSingleForAllCasesType().click();
                break;
            case SINGLE_WITH_BASELINE:
                addProjectPage.getSingleWithBaselineType().click();
                break;
            case MULTIPLE:
                addProjectPage.getmultipleType().click();
                break;
        }

        addProjectPage.getAcceptButton().click();

        return  new ProjectsPage(browsersService, false);
    }



    public void UpdateProject(Project project) {

    }

    public void DeleteProject(Project project) {

    }
}
