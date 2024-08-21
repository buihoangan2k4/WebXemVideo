<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>${video.title}</title>
<%@ include file="/common/head.jsp"%>
</head>
<body>
	<%@ include file="/common/header.jsp"%>

	<div class="container-fluid tm-container-content tm-mt-60">
		<div class="row mb-4">
			<h2 class="col-12 tm-text-primary">${video.title}</h2>
		</div>
		<div class="row tm-mb-90">
			<div class="col-xl-8 col-lg-7 col-md-6 col-sm-12">
				<iframe id="tm-video"
					src="https://www.youtube.com/embed/${video.href}"
					style="min-height: 500px !important;"></iframe>
			</div>
			<div class="col-xl-4 col-lg-5 col-md-6 col-sm-12"
				style="min-height: 500px !important;">
				<div class="tm-bg-gray tm-video-details">
					<c:if test="${not empty sessionScope.currentUser}">
						<div class="text-center mb-5">
							<button id="likeOrUnlike" class="btn btn-primary tm-btn-big">
								<c:choose>
									<c:when test="${flagLikedBtn == true}">
										Unlike
									</c:when>
									<c:otherwise>Like</c:otherwise>
								</c:choose>
							</button>
						</div>
						<div class="text-center mb-5">
							<a href="#" class="btn btn-primary tm-btn-big">Share</a>
						</div>
					</c:if>
				</div>
			</div>
			<input type="hidden" id="videoIdHdn" value="${video.href}">
		</div>
	</div>
	<!-- container-fluid, tm-container-content -->
	<%@ include file="/common/footer.jsp"%>
</body>
</html>
<script type="text/javascript">
	$('#likeOrUnlike').click(function() { // Sửa lỗi bằng cách thêm ()
		var videoId = $('#videoIdHdn').val();
		$.ajax({
			url : 'video?action=like&id=' + videoId, // Xóa khoảng trắng xung quanh dấu '='
			method : 'GET' // Chỉ định phương thức HTTP một cách rõ ràng
		}).then(function(data) {
			var text = $('#likeOrUnlike').text(); // Sửa tên biến từ 'test' thành 'text'
			if (text.indexOf('Like') !== -1) { // Sửa điều kiện để kiểm tra 'Like'
				$('#likeOrUnlike').text('Unlike'); // Sửa nội dung văn bản
			} else {
				$('#likeOrUnlike').text('Like'); // Sửa nội dung văn bản
			}
		}).fail(function(error) {
			alert('Rất tiếc!!! Vui lòng thử lại -_-');
		});
	});
</script>