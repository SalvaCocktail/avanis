package avanis.custom.login.hubspot;

import java.util.List;

public interface HubspotService {

    void sendPasswordResetEmailUseCase(String destEmail, String name, String tempPassword);
    void sendSignupRequestCreatedEmailUseCase(String userEmail, String name, String signupUrl);
    void formLoginUser(String email, String userId);
    void sendUserIsAlreadyRegistered(String userEmail,String name, String loginUrl, String recoveryUrl);
    void formSignupRequest(String email, String name, String surname, String phone, boolean allowNewsletter, String signupUrl);
    void subscribeNewsletter(String email);
    void formSignupUser(String email);
    void formPreferencesSteps(String userEmail, String dedication, String agriculture, String stockBreeding,
                              String sales, String transforming, String techAgrotech, String startups, String other, List<String> agricultureActivity,
                              List<String> stockBreedingActivity, List<String> agricultureInterest, List<String> stockBreedingInterest, List<String> otherInterest);
}
