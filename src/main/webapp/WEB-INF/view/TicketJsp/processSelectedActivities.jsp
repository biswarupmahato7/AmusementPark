<%@ page import="java.util.List, java.util.ArrayList, org.snowpark.model.*" %>
<%
  List<Activity> selectedActivities = new ArrayList<Activity>();
  List<Activity> activities = getActivities(); // Replace with your code to retrieve activities

  // Check if the form has been submitted
  if (request.getMethod().equalsIgnoreCase("post")) {
    // Get the parameter names submitted with the form
    String[] paramNames = request.getParameterValues("activity");

    // Check which activities have been selected
    for (String paramName : paramNames) {
      int activityId = Integer.parseInt(paramName);
      Activity activity = getActivityById(activityId); // Replace with your code to retrieve an activity by ID
      selectedActivities.add(activity);
    }

    // Do something with the selected activities, such as storing them in a database
    storeSelectedActivities(selectedActivities); // Replace with your code to store selected activities
  }
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Select activities</title>
</head>
<body>
    <h1>Select activities</h1>
    <form method="post" action="">
      <table>
        <thead>
          <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Select</th>
          </tr>
        </thead>
        <tbody>
          <% for (Activity activity : activities) { %>
          <tr>
            <td><%= activity.getActivityId() %></td>
            <td><%= activity.getActivityDesc() %></td>
            <td><input type="checkbox" name="activity" value="<%= activity.getActivityId()%>"></td>
          </tr>
          <% } %>
        </tbody>
      </table>
      <input type="submit" value="Submit">
    </form>
</body>
</html>