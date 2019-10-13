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
        console.log(commenList);

        var commentHtml = '';
        for (var i = 0; i < commenList.length; i++) {
            var comment = commenList[i];
            var teacher = comment.teacher;

            commentHtml += '<div class="panel"> ' +
                                '<div class="panel-body">' +
                                    '<p>' + comment.answerAns + '' +
                                        '<text id="tip" style="color: red;float: right;"></text>' +
                                    '</p>' +
                                    '<p style="width: 100%;">' + teacher.teacherName + '&nbsp;&nbsp;&nbsp;&nbsp;回答于&nbsp;' + new Date(comment.createTime).Format("yyyy-MM-dd hh:mm") +
                                        '<button type="button" class="btn btn-danger" style="float:right" onclick="deleteComment(' + comment.answerId + ')">刪除</button>'+
                                    '</p>' +
                                '</div>' +
                            '</div>';

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
            if (data.success == true) {
                document.getElementById('textArea').value = '';
                comment(questionIdGlobal);
            }
        }
    });

}

function deleteComment(answerId) {
    var url = "/mission/deletcomment";

    console.log(answerId)

    var permission = 0;
    $.ajax({
        url: url,
        type: "GET",
        async: false,
        data: {
            answerId: answerId,
        },
        dataType: 'json',
        success: function (data) {
            if (data.success == true) {
                document.getElementById('tip').innerText = '删除成功！';
                console.log("success")
                console.log(data)
            }else{
                document.getElementById('tip').innerText = '不能删除他人的评论！';
                console.log("false")
                console.log(data)
            }
            permission = data.permission;

        }
    });
    // if(permission == 1){
    //     console.log("permission = " + permission)
    //     $('#tip').text("删除成功")
    // }else{
    //     console.log("permission = " + permission)
    //     $('#tip').text("不能删除他人的评论")
    // }

    // $('#tip').text("666")

    // console.log("before sleep")
    // sleep(2000);
    // console.log("after sleep")
    //
    // comment(questionIdGlobal)
    // setTimeout(comment(questionIdGlobal), 12000)


}

//时间停留：ms
function sleep(n) { //n表示的毫秒数
    var start = new Date().getTime();
    while (true) if (new Date().getTime() - start > n) break;
}  
