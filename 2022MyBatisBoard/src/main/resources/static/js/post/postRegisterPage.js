//$(document).ready(function() {
//	//파일 첨부 ▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼	
//	var objDragAndDrop = $(".dragAndDropDiv");
//	var rowCount = 0;
//
//	/* 박스 안에 Drag 들어왔을 때 */
//	$(document).on("dragenter", ".dragAndDropDiv", function(e) {
//		e.stopPropagation(); // stopPropagation 은 부모 태그로의 이벤트 전파를 stop 중지하라는 의미
//		e.preventDefault(); // preventDefault 는 a 태그 처럼 클릭 이벤트 외에 별도의 브라우저 행동을 막기 위해 사용
//		$(this).css('border', '2px solid #0B85A1');
//	});
//
//	/* 박스 안에서 Drag를 Drop했을 때 */
//	$(document).on("drop", ".dragAndDropDiv", function(e) {
//		$(this).css('border', '2px dotted #0B85A1');
//		e.preventDefault();
//		var files = e.originalEvent.dataTransfer.files; //드래그앤 드랍 했을 때 파일에 대한 정보
//		console.log("테스트@@@@@@@@@@@" + files);
//		handleFileUpload(files, objDragAndDrop);
//		$("#input" + rowCount).prop("files", files);
//	});
//
//	/* 박스 안에 Drag를 하고 있을 때 */
//	$(document).on('dragover', function(e) {
//		e.stopPropagation();
//		e.preventDefault();
//		objDragAndDrop.css('border', '2px dotted #0B85A1');
//	});
//
//	//	/* 박스 밖으로 Drag가 나갈 때 */
//	//    $(document).on('dragleave', function(e) {
//	//		e.stopPropagation();
//	//		e.preventDefault();
//	//     console.log('dragleave');
//	//    });
//
//	/* 박스 안에서 Drag를 Drop했을 때 실행 되는 function */
//	function handleFileUpload(files, obj) {
//		for (var i = 0; i < files.length; i++) {
//			var fd = new FormData(); //controller로 넘겨줄 FormData 객체 생성
//			fd.append('file', files[i]);
//			var status = new createStatusbar(obj); // 생태 바 객체 생성, Using this we can set progress.
//			status.setFileNameSize(files[i].name, files[i].size);
//			status.setProgress(100);
//
//			sendFileToServer(fd, status); // formData 객체와 상태 바 객체를 보낸다
//		}
//
//	}
//
//	// 상태 바
//	function createStatusbar(obj) {
//		rowCount++;
//		this.statusbar = $("<div class='statusbar'></div>");
//
//		$("<input multiple='multiple' type='file' name='file' id='input" + rowCount + "' class='multipleInput'>").appendTo(this.statusbar);
//
//		this.size = $("<div class='filesize'></div>").appendTo(this.statusbar);
//		this.progressBar = $("<div class='progressBar'><div></div></div>").appendTo(this.statusbar);
//		this.abort = $("<div class='abort'>삭제</div>").appendTo(this.statusbar);
//
//		obj.after(this.statusbar);
//
//		this.setFileNameSize = function(name, size) {
//			var sizeStr = "";
//			var sizeKB = size / 1024;
//			if (parseInt(sizeKB) > 1024) {
//				var sizeMB = sizeKB / 1024;
//				sizeStr = sizeMB.toFixed(2) + " MB";
//			} else {
//				sizeStr = sizeKB.toFixed(2) + " KB";
//			}
//
//			this.size.html(sizeStr);
//		}
//
//		/* 퍼센트(%)바  */
//		this.setProgress = function(progress) {
//			var progressBarWidth = progress * this.progressBar.width() / 100;
//			this.progressBar.find('div').animate({ width: progressBarWidth }, 10).html(progress + "% ");
//
//		}
//
//		this.setAbort = function(jqxhr) {
//			var sb = this.statusbar;
//			this.abort.click(function() //중지 클릭 부분
//			{
//				var test = $(this).parent();
//
//				test.remove();
//
//			});
//		}
//	}
//
//	function sendFileToServer(formData, status) {
//		var uploadURL = "/fileUpload/post"; //Upload URL
//		var extraData = {}; //Extra Data.
//		var jqXHR = $.ajax({
//			xhr: function() {
//				var xhrobj = $.ajaxSettings.xhr();
//				if (xhrobj.upload) {
//					xhrobj.upload.addEventListener('progress', function(event) {
//						var percent = 0;
//						var position = event.loaded || event.position;
//						var total = event.total;
//						if (event.lengthComputable) {
//							percent = Math.ceil(position / total * 100);
//						}
//						//Set progress
//						status.setProgress(percent);
//					}, false);
//				}
//				return xhrobj;
//			},
//			url: uploadURL,
//			type: "POST",
//			contentType: false,
//			processData: false,
//			cache: false,
//			data: formData,
//			success: function(data) {
//				status.setProgress(100);
//			}
//		});
//
//		status.setAbort(jqXHR);
//	}
//	//파일 첨부 끝 ▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲
//}); // document ready END