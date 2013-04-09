<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="jquery/jquery-1.4.4.min.js"></script>
<script type="text/javascript" src="jquery/jquery.jqUploader.js"></script>
<script type="text/javascript" src="jquery/jquery.flash.js"></script>

<script>
	function test () {
		$('#test').find('progress').attr({
			value : 0,
			max : 100
		});
		//create a FormData Object that will be sent
		var formData = new FormData($('#test').find('form')[0]);
		$.ajax({
			url : 'xyz/controlling/multiPartFileSingle', //server script to process data
			type : 'POST',
			xhr : function() { // custom xhr
				myXhr = $.ajaxSettings.xhr();
				if (myXhr.upload) { // check if upload property exists
					myXhr.upload.addEventListener('progress', function(evt) {
						if (evt.lengthComputable) {
							$('#test').find('progress').attr({
								value : evt.loaded,
								max : evt.total
							});
						}
					}, false); // for handling the progress of the upload
				}
				return myXhr;
			},
			//Ajax events
			//beforeSend: beforeSendHandler,
			success : function(data) {
				if (data.successMessage) {//
					//set progress to 100%
					$('#test').find('progress').attr({
						value : 100,
						max : 100
					});
				}
				if (data.errorMessage) {
					console.log("error uploading file");
				}
			},
			data : {fileUp : $('fileUp') },
			cache : false,
			contentType : false,
			processData : false
		});
	}
</script>

</head>
<body>
	<form name="form1" id="form1" action="xyz/controlling" method="post"
		enctype="multipart/form-data">
		File to upload: <br /> <input type="file" size="50" name="aFile">
		<br /> <input type="submit" value="Upload" id="submitButton">
	</form>



	<div id="test">
	<label>select a file to upload</label>
	<form enctype="multipart/form-data">
		<input id="fileUp" multiple="true" name="fileUp" type="file">
		<input type="button" value="Upload" onclick="test();">
	</form>
	<progress></progress>
	</div>


</body>
</html>