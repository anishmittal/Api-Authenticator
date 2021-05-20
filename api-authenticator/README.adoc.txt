All API calls will go through HandlerInterceptor. After checking for the API Key in the 
HttpRequest Header, it forwards the request to appropriate Controller.

There are Controller for all REST APi calls.
PropertyRepository class is used for interactive with database.
PropertyService class acts as intermediary link between Controller and Repository layer.
