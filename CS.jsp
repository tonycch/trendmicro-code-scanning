<html>
	<head>
		<title>sample script</title>
	</head>
	<%
		String eid1 = request.getParameter("eid");
		
		String eid2 = request.getParameter("eid");
		if (!validateInput2(eid2))
		{
			eid2 = "";
		}

		testObject to = new testObject(); 
		to.eid = request.getParameter("eid");
		to.cleanVal();
	%>

	<%!
		String validateInput(String arg)
		{
			if (!arg.matches("^[A-Z a-z 0-9]*$") && !arg.matches("^[A-Z a-z 0-9]*$")){
				arg = "";
			}
			return arg;
		}

		Boolean validateInput2(String arg)
		{
			if (!arg.matches("^[A-Z a-z 0-9]*$") && !arg.matches("^[A-Z a-z 0-9]*$")){
				return false;
			}
			return true;
		}

		public class testObject
		{
			String eid = "";
			public void cleanVal()
			{
				if (!eid.matches("^[A-Z a-z 0-9]*$") && !eid.matches("^[A-Z a-z 0-9]*$")){
					eid = "";
				}
				return;
			}
		}
	%>
	<body>
		Employee ID: <%= validateInput(eid1) %>
		Employee ID: <%= eid2 %>
		Employee ID: <%= to.eid %>
	</body>
</html>