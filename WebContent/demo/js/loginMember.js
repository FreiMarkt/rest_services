// function that actualy saves the member
function loginMember(member) {
  var request = new XMLHttpRequest();
  request.open("POST", "/rest_services/r/member/login", false);
  request.setRequestHeader("Content-type","application/json");
  request.send(JSON.stringify(member));
  
  return JSON.parse(request.responseText);
}