# LiferayForm

This document presents the test plan for the current version of the website Liferay Forms, available at http://forms.liferay.com/web/forms/shared/-/form/372406. This release is focused on the implementation of one main feature, the submission of users’ information through the form. In addition, validations regarding screen layout are required in this moment.



# Before Executing Scripts

Before executing the testing scripts please make sure you change the following changes:

1 - In the package <b> suporte </b> in the class <b> Web </b>, change the local path for Chrome Driver.

2 - In the class test <b> UserInfo </b> under <b> @Rule > "String screens" </b> change the local path to save the screenshots from tests.
