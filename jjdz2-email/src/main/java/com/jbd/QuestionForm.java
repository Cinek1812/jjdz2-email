//package com.jbd;
//
//import static com.jbd.SearchCriteria.*;
//
//public class QuestionForm {
//
//    private static String EMAIL_QUESTION = "Provide email address.";
//    private static String KEYWORD_QUESTION = "Provide keywords to find in email subject. Separate them with commas.";
//    private static String STARTDATE_QUESTION = "Provide start date (YYYY-MM-DD)";
//    private static String ENDDATE_QUESTION = "Provide end date (YYYY-MM-DD)";
//    private static String NUMBER_OF_EMAILS_QUESTION = "How many email addresses would you like to find?";
//
//    private static String EMAIL_QUESTION_WRONG_VALUE = "Wrong format, please try again.";
//    private static String STARTDATE_QUESTION_WRONG_VALUE = "Wrong format or invalid date, please provide new start date (YYYY-MM-DD)";
//    private static String ENDDATE_QUESTION_WRONG_VALUE = "Wrong format or invalid date, please provide new end date (YYYY-MM-DD)";
//    private static String ADDITIONAL_EMAIL_QUESTION = "Provide additional email address.";
//
//    public void askQuestionsAndSetAnswers() {
//        UserCommunication sendMessage = new UserCommunication();
//        SearchCriteriaValidator searchCriteriaValidator = new SearchCriteriaValidator();
//        SearchCriteria searchCriteria = new SearchCriteria();
//        String emailAddress = "";
//
//        int numberOfEmailAddresses;
//        sendMessage.sendUserMessage(NUMBER_OF_EMAILS_QUESTION);
//        numberOfEmailAddresses = Integer.valueOf(sendMessage.getUserResponse());
//
//        for (int index = 0; index < numberOfEmailAddresses; index++) {
//            do {
//                sendMessage.sendUserMessage(EMAIL_QUESTION);
//                emailAddress = sendMessage.getUserResponse();
//                setEmail(emailAddress);
//                if (searchCriteriaValidator.validateEmail(emailAddress) == false) {
//                    EMAIL_QUESTION = EMAIL_QUESTION_WRONG_VALUE;
//                } else if (!(numberOfEmailAddresses == 1 && index == 0)) {
//                    EMAIL_QUESTION = ADDITIONAL_EMAIL_QUESTION;
//                }
//            } while (!searchCriteriaValidator.validateEmail(emailAddress));
//        }
//
//        do {
//            sendMessage.sendUserMessage(STARTDATE_QUESTION);
//            setStartDate(sendMessage.getUserResponse());
//            if (searchCriteriaValidator.validateStartDate(searchCriteria.getStartDate()) == false) {
//                STARTDATE_QUESTION = STARTDATE_QUESTION_WRONG_VALUE;
//            }
//        } while (!searchCriteriaValidator.validateStartDate(searchCriteria.getStartDate()));
//
//        do {
//            sendMessage.sendUserMessage(ENDDATE_QUESTION);
//            setEndDate(sendMessage.getUserResponse());
//            if (searchCriteriaValidator.validateEndDate(searchCriteria.getEndDate()) == false) {
//                ENDDATE_QUESTION = ENDDATE_QUESTION_WRONG_VALUE;
//            }
//        } while (!searchCriteriaValidator.validateEndDate(searchCriteria.getEndDate()));
//
//        sendMessage.sendUserMessage(KEYWORD_QUESTION);
//        setKeywords(sendMessage.getUserResponse());
//    }
//}