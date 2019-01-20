//댓글 byte 크기 체크(onkeyup, onblur)
function countReplyBytes() {
	var replyContents = document.getElementById('input-ReContent').value;
	var intCharCount = 0;
	var maxBytes = 300;
	var contentsCharacter;
	var lastIndex;

	for (var index = 0; index < replyContents.length; index++) {
		contentsCharacter = replyContents.charAt(index);

		if (escape(contentsCharacter).length > 4) {
			intCharCount += 3;
		} else {
			intCharCount++;
		}

		if (intCharCount > maxBytes) {
			lastIndex = index;
		}
	}

	// 300 bytes 초과시 댓글 추가 작성 못하게..
	if (intCharCount > maxBytes) {
		var contentsCutOver = replyContents.substring(0, lastIndex);
		document.getElementById('input-ReContent').value = contentsCutOver;
	}

	var viewReplyBytestArea = document.getElementById('view-reply-bytes');
	viewReplyBytestArea.innerHTML = intCharCount + '/300 bytes';
}