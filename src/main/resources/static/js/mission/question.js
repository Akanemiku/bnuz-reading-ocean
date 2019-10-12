var questionIdGlobal;
function comment(questionId) {
    $('#comment').html("")           //更行评论
    questionIdGlobal = questionId;
    var url = "/mission/questioncommonlist";
    // console.log(questionId);

    $.ajax({
        url: url,
        type: "GET",
        data: {
            'questionId': questionId,
        },
        dataType: 'json',
        success: function (data) {
            // console.log(data.questioncommonlist);
            addCommentHtml(data.questioncommonlist)
        }
    });

    function addCommentHtml(commenList) {

        var commentHtml = '';
        for (var i = 0; i < commenList.length; i++) {
            var comment = commenList[i];
            var teacher = comment.teacher;


            commentHtml += '<div class="panel"> ' +
                '<div class="panel-body">' +
                '<p>' + comment.answerAns + '</p>' +
                '<p>' + teacher.teacherName + '&nbsp;&nbsp;&nbsp;&nbsp;回答于&nbsp;' + new Date(comment.createTime).Format("yyyy-MM-dd hh:mm") + '</p>' +
                '</div>' +
                '</div>'
        }
        $('#comment').html(commentHtml)
    }


}

function addComment(questionId, teacherId) {
    var url = "/mission/addcomment";

    // console.log(questionId);
    // console.log(comment);

    $.ajax({
        url: url,
        type: "GET",
        data: {
            questionId: questionId,
            teacherId: teacherId,
            answerAns: $('#textArea').val(),
        },
        dataType: 'json',
        success: function (data) {
            if(data.success == true){
                document.getElementById('textArea').value = '';
                comment(questionIdGlobal);
            }
        }
    });


}