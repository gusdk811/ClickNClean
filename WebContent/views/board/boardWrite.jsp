<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>글 작성하기</title>

    <link rel="stylesheet" href="/assets/css/theme.min.css">
    <link rel="stylesheet" href="/assets/css/docs.min.css">
</head>
<body>
<div class="container content-space-2 content-space-lg-3">
        <div class="w-lg-75 mx-lg-auto">
            <!--제목-->
            <div class="pagination justify-content-center display-5 ">
                <p class="" style="text-decoration-line: underline; color:#555;">공지사항 및 FAQ - 회원</p>
            </div>

            <div class="mb-5">
                <a class="link" href="">
                    <i class="bi-chevron-left small ms-1"></i> 목록으로
                </a>
            </div>

            <div class="card card-bordered shadow-none">
                <div class="card-body">

                    <form>
 
                        <div class="row mb-3">

                            <div class="col-sm-9">

                                <div class="d-flex align-items-center">

                                    <div class="d-grid d-sm-flex gap-2 ms-4">
                                    </div>

                                </div>
                            </div>

                            <!-- Form -->
                            <div class="row mb-3">
                                <label class="col-sm-3 col-form-label">제목</label>
                                <div class="col-sm-9">
                                    <input type="text" class="form-control form-control-lg" id="submitAppProjectName">
                                </div>
                            </div>
                            
                            <div class="row mb-3">
                                <label class="col-sm-3 col-form-label">작성일</label>
                                <div class="col-sm-9">
                                   <form>
                                    <input type="date"  class="form-control form-control-lg" id="date">
                                    </form>
                                    
                                    <script>
                                     document.getElementById('date').value = new Date().toISOString().substring(0, 10);;
                                    </script>
                                </div>
                            </div>

                            <div class="row mb-3">
                                <label class="col-sm-3 col-form-label form-label">작성자</label>
                                <div class="col-sm-9">
                                    <input type="text" class="form-control form-control-lg" id="submitAppWebsite">
                                </div>
                            </div>


                            <!-- Form-->
                            <div class="row mb-">
                                <label for="shortDescriptionLabel" class="col-sm-3 col-form-label form-label">내용</label>

                                <div class="col-sm-9">
                                    <div class="d-flex justify-content-end">
                                        <span id="maxLengthShortDescriptionCountCharacters" class="form-label-secondary"></span>
                                    </div>

                                    <textarea class="js-count-characters form-control" id="shortDescriptionLabel"></textarea>
                                </div>
                            </div>

                            <div class="text-center mt-5">
                                <button type="submit" class="btn btn-primary btn-lg">등록하기</button>
                            </div>
                        </div>
                    </form>

                </div>
            </div>

        </div>
    </div>

</body>
</html>