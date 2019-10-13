$(document).ready(function () {
    addTask();
});

var checkedBookNumber = 0;


// 输入关键字查找学生
function search(index) {
    var stuName = [];
    var stuList = $('.stuList').eq(index).find('li');
    for (var i = 0; i < stuList.length; i++) {
        var students = stuList.eq(i).text();
        stuName.push(students);
    }
    // 输入关键字查询学生
    $(".searchForm input").keyup(function () {
        stuList.hide();
        var input = $(".searchForm input").val();
        for (var j = 0; j < stuList.length; j++) {
            if (stuName[j].indexOf(input) >= 0) {
                stuList.eq(j).show();
            }
        }
    });
}

// 全选与全不选
function select(i) {
    var selectAll = $(".selectAll").eq(i); // 全选
    var stuList = $(".stuList").eq(i).find(" li input");
    var selectAllBox = $('.All').eq(i).find('input');
    selectAllBox.click(function () {
        if (selectAllBox.prop('checked')) {
            selectAll.show();
            stuList.each(function () {
                $(this).prop("checked", true);
            });
        } else {
            selectAll.show();
            stuList.each(function () {
                $(this).prop("checked", false);
            });
        }
    });

    // 手动选
    stuList.each(function () {
        $(this).click(function () {
            if (selectAllBox.prop('checked')) {
                selectAllBox.prop('checked', false);
                selectAll.show();
            } else {
                var status = true;
                stuList.each(function () {
                    if (!($(this).prop('checked'))) {
                        status = false;
                    }
                });
                if (status) {
                    selectAllBox.prop('checked', true);
                    selectAll.show();
                }
            }
        });
    });
}

//竞赛全选
function select2(i) {
    var selectAll2 = $(".selectAll2"+i), // 全选
        deselectAll2 = $(".deselectAll2"+i); // 全不选
    var touch = $('#touch' + i);
    touch.click(function(){
//		alert($(".gradeList .color").attr("id"));//拿到对应的id
//		var id = $(".gradeList .color").attr("id");
        var classesList = $("#cla"+i).find(" li input");
        if (touch.prop('checked')) {
            selectAll2.hide();
            deselectAll2.show();
            classesList.each(function () {
                $(this).prop("checked", true);
            });
        } else {
            selectAll2.show();
            deselectAll2.hide();
            classesList.each(function () {
                $(this).prop("checked", false);
            });
        }
//		alert("xhh"+i);
    })
}

// 收起和展示所有学生
function showAllStu(index) {
    var ok = 0;
    $('.down').eq(index).click(function () {
        ok = 1;
        if (ok) {
            $('.stuList').eq(index).toggleClass('autoHeight');
            $(this).toggleClass('rotate');
            // console.log(1);
        }
    });
}

// 发布任务、已发布按钮切换
$(function () {
    var link = window.location.search.split('=');
    var index = 0;
    for (var i = 0; i < link.length; i++) {
        if (link[i].indexOf('ex') >= 0) {
            index = 1;
        }else if(link[i].indexOf('competition') >= 0) {
            index = 2;
        }else if(link[i].indexOf('situation') >= 0) {
            index = 3;
        }
    }
    var type = link[1];
    if (index == 0) {
        $('.main').show();
        $('.published').hide();
        $('.main_competition').hide();
        $('.main_situation').hide();
        $('.header a').removeClass('current');
        $('#releaseTask').addClass('current');
    } else if (index == 1) {
        $('.main').hide();
        $('.main_competition').hide();
        $('.main_situation').hide();
        $('.published').show();
        $('.header a').removeClass('current');
        $('#released').addClass('current');
    }else if (index  == 2) {
        $('.main').hide();
        $('.main_situation').hide();
        $('.published').hide();
        $('.main_competition').show();
        $('.header a').removeClass('current');
        $('#competition').addClass('current');
    }else if (index  == 3) {
        $('.main').hide();
        $('.main_competition').hide();
        $('.published').hide();
        $('.main_situation').show();
        $('.header a').removeClass('current');
        $('#situation').addClass('current');
    }
});

// 发布任务页面中，点击选择任务
$('.task-option ul li input').each(function (index) {
    $(this).click(function () {
        var option = $(this).val(); // 选项卡的值
        var text = $('#taskDescribe').val(); // 描述任务中的值
        if ($(this).prop('checked')) {
            var list = $(this).val();
            $('.describe ul').append('<li><input type="checkbox" checked="" >' + list + '</li>');
        } else {
            $('.describe ul li').each(function (index) {
                if ($(this).text() === option) {
                    $(this).remove();
                }
            });
        }
    });
});

// 发布任务

// $('.submit').click(function() {
// var taskDescribe = $('#taskDescribe');
// var taskDescribe = taskDescribe.val();
// textType = "";
// $('.describe ul li').each(function(index) {
// textType += ((index + 1) + '.' + $(this).text());
// });
// });

// 反向去掉已选择任务的选中栏
$('.describe ul').delegate('li>input', 'change', function () {
    var tasktype = $(this).parent().text();
    $(this).parent().remove();
    var taskOption = $('.task-option ul li input');
    taskOption.each(function (index) {
        if (taskOption[index].value == tasktype) {
            $(taskOption[index]).removeAttr('checked');

        }
    });
    $(this).parent().remove();
});
var index = 0;

//添加主观题
$('.plus_task').click(function(){
    index++;
    addlist(index);
});
function addlist(index){
    var html=''
    html+='<div class="zhuguan">';
    html+=    '<h4>主观题(必填)</h4>';
    html+=    '<textarea placeholder="请输入您要发布的题目描述" id="task' + index + '"></textarea>	';
    html+=    '<button class="closeZhuguan" >删 除</button>';
    html+='</div>';
    $('.body_right').append(html);
    //删除主观题
    $('.closeZhuguan').click(function(){
        $(this).parents('.zhuguan').remove();
    });
}

var currentBookPage = 1;
var maxBookPage = 0;
var pageSize = 10;
var currentBookCate = "all";
var selectedBook = [];


// 页面加载完绑定按钮
$(document).ready(function(){
    getBookCategory();
    // 弹出层选择书
    // 籍
    $(".plus").click(function () {
        $(".popup").show();
        $(".bookForm").slideDown();
        $('.Page').show();
        $("body").css("overflow", "hidden");

        // 模拟点击全部分类
        $(".category_all").click();
        checkedBookNumber = $('.body .closeBook').length;
        // bookList();
    });
    //竞赛任务的添加书籍
    $(".plus2").click(function () {
        $(".popup").show();
        $(".bookForm").slideDown();
        $('.Page').show();
        $("body2").css("overflow", "hidden");

        // 模拟点击全部分类
        $(".category_all2").click();
        checkedBookNumber = $('.body .closeBook').length;
        // bookList();
    });
    // 关闭弹出层
    $("#confirmBook1").click(function () {//cc改了.confirmBook

        $.each(selectedBook, function(index, book) {
            // 移除原本节点点击事件
            book.unbind("click");
            book.find('label').remove();
            // 添加一个删除按钮
            book.append("<button class='closeBook'>X</button>");
            book.append('<label><input type="radio" name="'+book.attr("id")+'chose" value="1" checked="checked">必读</label><label><input type="radio" name="'+book.attr("id")+'chose" value="0">选读</label>');
            // 给添加的删除按钮添加新的点击事件
            book.find(".closeBook").click(function(){
                // 先移除本地数据里添加的节点
                selectedBook = selectedBook.filter(function(item) {
                    return item.attr("id") !== book.attr("id");
                });
                // 再移除待发布区域里显示的对应节点
                book.parent().find(book).remove();
            })
            // 将构造完的节点加入显示区域
            $('.body ul').append(book);
        })
//	    var choiceBook = (function () {
//	        var totalBooks = $('.body ul');
//	        totalBooks.find("li").remove();
//	        var hasBookId = function (bookId) {
//	            var hasId = false;
//	            $(totalBooks).find('li').each(function () {
//	                if ($(this).attr('id') === bookId) {
//	                    hasId = true;
//	                    return false;
//	                }
//	            });
//	            return hasId;
//	        };
//
//	        $('.bookList li.style').each(function () {
//	            var bookId = $(this).prop("id"),
//	                pic = $(this).find("img").prop("src"),
//	                bookName = $(this).find("h3").text();
//	            if (!hasBookId(bookId)) {
//	                totalBooks.append('<li id=' + bookId + ' title=' + bookName + '><img src=' + pic + '><h3>' +
//	                    bookName + '</h3><button class="closeBook">X</button></li>');
//	                // 删除选中的书籍
//	                $('.closeBook').click(function () {
//	                    $(this).parent("li").remove();
//	                });
//	            }
//	        });
//	    })();
        $(".popup").hide();
        $(".bookForm").slideUp();
        $("body").css("overflow", "auto");
        currentBookPage = 1;
        maxBookPage = 0;
        currentBookCate = "all";
        $(".bookList").empty();
    })

    $("#confirmBook2").click(function () {

        $.each(selectedBook, function(index, book) {
            // 移除原本节点点击事件
            book.unbind("click");
            book.find('label').remove();
            // 添加一个删除按钮
            book.append("<button class='closeBook'>X</button>");
            book.append('<label><input type="radio" name="'+book.attr("id")+'chose" value="1" checked="checked">必读</label><label><input type="radio" name="'+book.attr("id")+'chose" value="0">选读</label>');
            // 给添加的删除按钮添加新的点击事件
            book.find(".closeBook").click(function(){
                // 先移除本地数据里添加的节点
                selectedBook = selectedBook.filter(function(item) {
                    return item.attr("id") !== book.attr("id");
                });
                // 再移除待发布区域里显示的对应节点
                book.parent().find(book).remove();
            })
            // 将构造完的节点加入显示区域
            $('.body2 ul').append(book);

        })

        $(".popup").hide();
        $(".bookForm").slideUp();
        $("body").css("overflow", "auto");
        currentBookPage = 1;
        maxBookPage = 0;
        currentBookCate = "all";
        $(".bookList").empty();
    })

    // 取消选择按钮
    $('.cancelBook').click(function () {
        $('.bookList').each(function (index) {
            $(this).removeClass('style');
        });
        $(".popup").hide();
        $(".bookForm").slideUp();
        $("body").css("overflow", "auto");
        currentBookPage = 1;
        maxBookPage = 0;
        currentBookCate = "all";
    });
    $('.prev').click(function(){
        if( currentBookPage > 1){
            --currentBookPage;
            $(".bookList").empty();
            getBooks(currentBookCate,pageSize,currentBookPage);
        }
    });
    $('.next').click(function(){
        if(currentBookPage < maxBookPage){
            ++currentBookPage;
            $(".bookList").empty();
            getBooks(currentBookCate,pageSize,currentBookPage);
        }
    });
    $('.first').click(function(){
        if(currentBookPage > 1){
            currentBookPage = 1;
            $(".bookList").empty();
            getBooks(currentBookCate,pageSize,currentBookPage);
        }
    });
    $('.last').click(function(){
        if(currentBookPage < maxBookPage){
            currentBookPage = maxBookPage;
            $(".bookList").empty();
            getBooks(currentBookCate,pageSize,currentBookPage);
        }
    });

    $('.searchBookForm button').click(function(){
        var searchBookText = $('.searchBookForm input').val();
        if ( searchBookText.length === 0 ) {
            alert("搜索内容不能为空");
        } else {
            $('.bookList').empty();
            // 恢复当前页数为第一页
            currentBookPage = 1;
            // 保证只能搜索全部分类的书籍
            currentBookCate = "all";
            getBooks(currentBookCate, 10, currentBookPage, searchBookText);
            // 清空搜索框
            $('.searchBookForm input').val("")
        }
    });

    // 按下回车键搜索
    $('.searchBookForm input').keydown(function(){
        if (event.keyCode == "13") {// keyCode=13是回车键
            $('.searchBookForm button').click();
        }
    });

})










// 任务详情版块
$(document).ready(function () {
    showAssess();
    cancel();
    addIntegral();
})

// 显示评分等级
function showAssess() {
    var path = $('input[type="hidden"]').val();
    var judge = $('.judge'),
        judging = $('.judging');
    var assessed = true;
    var assInput = $('input[name="assess"]');
    // 当有学生已经完成任务的时候，显示评价按钮
    $('.finishStu label').each(function (index) {
        var text = $(this).text();
        if (text.indexOf('已') > -1) {
            judge.show();
        }
        if (text.indexOf('，') > -1) {
            assessed = false;
        }
    });
    // 当还没有对任何学生进行评价时显示
    if (assessed) {
        $('.hasAssess').append('<p>您还没有对任何学生进行评价哦</p>');
    }
    judge.click(function () {
        var assessScore,
            assess, // 获取评价等级优良中
            scoreStr,
            score;
        $(this).hide();
        $('.judgeStudent').show();
        $('.okJudge').show();
        $('.cancel').show();
        $('.allStu').show();
        $('.comments').show();
        assInput.parent('label').show();
        $.ajax({
            type: 'GET',
            // url: path + "/sys/query",
            url: "/assess/info",
            data: {
                'type': 'teacher_add_type'
            },
            cache: false,
            dataType: 'json',
            success: function (json) {
                $.each(json.data, function (index) {
                    assInput.eq(index).val(this.name);
                    assInput.eq(index).parent('label').find('span').text(this.id + '（加' + this.name + '分）');
                });
                selectStu();
            },
            error: function () {
                return false;
            }
        });

        //获取加分项
        $.ajax({
            type: 'GET',
            // url: path + '/sys/query',
            url: '/assess/info',
            data: {
                'type': 'teacher_addplus_type'
            },
            cache: false,
            async: false,
            success: function(json) {
                var li = '';
                $.each(json.data, function(index, ele){
                    li += '<li class="add-li"><label><input type="checkbox" name="integral" value="'+ this.name +'"><span>'+ this.id + '</span>。('+ this.name +'分)</label></li>';
                });
                $('.comments ul').html(li);
            },
            error: function() {
                alert('获取评价分数表失败');
            }
        });
    });
}

// 取消评价
function cancel() {
    $('.cancel').click(function () {
        $('.judgeStudent').prop('checked', false);
        $('.judging').find('label input').prop('checked', false);
        $('.judgeStudent').hide();
        $('.okJudge').hide();
        $('.allStu').hide();
        $(this).hide();
        $('input[name="assess"]').parent('label').hide();
        $('.judge').show();
        $('.allStu').hide();
        $('.comments').hide();
    });
}

// 全选与全不选
function selectStu() {
    var chooseAll = $(".chooseAll"), // 全选
        dechooseAll = $(".dechooseAll"); // 全不选
    var stuList = $(".judgeStudent");
    var selectAllBox = $('.allStu').find('input');
    selectAllBox.click(function () {
        if (selectAllBox.prop('checked')) {
            chooseAll.hide();
            dechooseAll.show();
            stuList.each(function () {
                $(this).prop("checked", true);
            });
        } else {
            chooseAll.show();
            dechooseAll.hide();
            stuList.each(function () {
                $(this).prop("checked", false);
            });
        }
    });
    // 手动选
    stuList.each(function () {
        $(this).click(function () {
            if (selectAllBox.prop('checked')) {
                selectAllBox.prop('checked', false);
                chooseAll.show();
                dechooseAll.hide();
            } else {
                var status = true;
                stuList.each(function () {
                    if (!($(this).prop('checked'))) {
                        status = false;
                    }
                });
                if (status) {
                    selectAllBox.prop('checked', true);
                    dechooseAll.show();
                    chooseAll.hide();
                }
            }
        });
    });
}

// 加分
function addIntegral() {
    // var path = $('input[type="hidden"]').val();
    var stuID = [],
        taskId,
        assess,
        integral = 0,
        grade,
        stuNum,
        assessScore;
    $('.okJudge').click(function () {
        stuID = [];
        taskId = $(this).attr('id');
        grade = true;
        // 获取优良中等级以及分值
        $('input[name="assess"]').each(function (index) {
            if ($(this).prop('checked')) {
                grade = false;
                integral = $(this).val();
                assessScore = $(this).parent('label').text().split('（');
                assess = assessScore[0];
            }
        });
        stuNum = true;
        // 获取学生id
        $('.judgeStudent').each(function (index) {
            if ($(this).prop('checked')) {
                stuNum = false;
                var id = $(this).attr('id');
                stuID = stuID + id + ',';
            }
        });

        //获取加分项和分数
        var param = $('.form-assess').serializeArray(),
            checkbox = $('.comments ul').find('input:checked'),
            paramlist = [],
            number = 0,
            assessPlus = [];

        $.each(param, function(){
            if (this.name === 'integral') {
                number += parseInt(this.value, 10);
            }
        });
        $.each(checkbox, function(){
            assessPlus.push($(this).next('span').text());
        });

        var strAssess = assessPlus.join('#');
        integral = parseInt(integral)+number;

        if (grade) {
            alert('请选择评分等级！');
            return false;
        } else if (stuNum) {
            alert('请选择需要评分的学生对象！');
            return false;
        } else {
            var conf = confirm('确定评价吗？');
            var allData = {
                'taskId': taskId,
                'students': stuID,
                'assess': assess,
                'assessPlus': strAssess,
                'integral': integral,
            };
            if (conf) {
                $.ajax({
                    type: 'POST',
                    // url: path + "/mission/assess",
                    url: "/task/assess",
                    // data: {
                    //     'taskId': taskId,
                    //     'students': stuID,
                    //     'assess': assess,
                    //     'assessPlus': strAssess,
                    //     'integral': integral,
                    // },
                    data:JSON.stringify(allData),
                    cache: false,
                    dataType: 'json',
                    contentType : "application/json;charset=UTF-8",
                    success: function (json) {
                        console.log(111);
                        console.log(strAssess);
                        console.log(integral);
                        console.log(222);
                        if (json.code == 200) {
                            alert('加分成功!');
                            window.location.reload();
                        } else if (json.code == 421) {
                            alert('今天的加分次数已达上限~');
                        } else {
                            alert("加分失败。失败代码：" + json.code + "；失败原因：" + json.result);
                        }
                    },
                    error: function () {
                        return false;
                    }
                });
            } else {
                return false;
            }
        }
    });
}

// //////////以上为task。jsp的js控制部分以及taskDetail.jsp部分
// //////////新增
// 获取任务的ID
var taskId = $('.okJudge').attr('id');
var studentId = "";
$(".Task_completion").click(function () {
    // 点击获取对应学生的ID
    studentId = $(this).attr('id');
    // 点击学生弹出对应学生完成任务的情况
    $(".popup").show();
    $("body").css("overflow", "hidden");
    $(".Tcompletion").slideDown(); // 弹出页
    Taskdetails();
    // conComment();
    // console.log("ok");
});
// 初始化信息显示
var TaskbookId = "";

function Taskdetails() {
    // var path = $('input[type="hidden"]').val();
    $.ajax({
        type: 'GET',
        url: "/mission/finishDetail",
        data: {
            'studentId': studentId,
            'taskId': taskId,
        },
        // async: true,
        cache: false,
        dataType: 'json',
        success: function (json) {
            console.log(json);
            studentId = json.studentId;
            // 姓名显示
            var nameList = $('.Taskdescription-head');
            $('.Taskdescription-head').find("h1").remove();
            nameList.prepend('<h1>' + json.studentName + '的完成情况</h1>');
            // 内容，部分引用了model，此部分只需要显示所需的，如要重新显示则需要重新修改此代码
            var tasktop = $('.Tasktop');
            $('.asli').remove();
            if(!json.assess){
                json.assess="暂无评价";
            }
            tasktop.append('<li class= "asli">' + json.assess + '</li>');
            // 分类显示操作
            $('.main-posts ul li').find("span").remove();
            $('.main-posts ul li').find("img").remove();
            $('.main-posts ul li').find("p").remove();
            $('.main-posts').find("div").remove();
            $('.main-posts').find("h1").remove();
            var post = $(".main-posts ul");
            datalistlength = json.forumPosts.dataList.length; // 获取dataList的长度
            // 分别获得datalist的数量
            for (var i = 0; i < datalistlength; i++) {
                // 日期转换
                var timestamp = json.forumPosts.dataList[i].dateTime;
                var str = " ";

                function dateTo() {
                    var newdate = new Date(timestamp);
                    str += newdate.getFullYear() + "-";
                    str += (newdate.getMonth() + 1) + "-";
                    str += newdate.getDate() + "-";
                    str += newdate.getHours() + " ";
                    str += newdate.getMinutes() + ":";
                    str += newdate.getSeconds();
                }

                dateTo();

                var pinglun = $('.pinglun'),
                    duhougan = $('.duhougan'),
                    huihua = $('.huihua'),
                    siwei = $('.siwei'),
                    note = $('.biji'),
                    langsong = $('.langsong'),
                    beisong = $('.beisong');
                var posttype = json.forumPosts.dataList[i].postType; // 获取每条datalist的相关项
                // 判断类型
                switch (posttype) {
                    case '评论':
                        pinglun.append('<span class = "type comment">' + json.forumPosts.dataList[i].postType + '</span>');
                        pinglun.append('<span class = "title" id="' + json.forumPosts.dataList[i].topicId + '">' + json.forumPosts.dataList

                            [i].postTitle + '</span>');
                        pinglun.append('<span class = "time">' + str + '</span>');
                        pinglun.append('<p class="contentp">' + json.forumPosts.dataList[i].postContent + '</p>');
                        pinglun.append('<li class="post-footer"><button class="open" type="button">展开</button></li>');
                        break;
                    case '读后感':
                        duhougan.append('<span class = "type feel">' + json.forumPosts.dataList[i].postType + '</span>');
                        duhougan.append('<span class = "title" id="' + json.forumPosts.dataList[i].topicId + '">' + json.forumPosts.dataList

                            [i].postTitle + '</span>');
                        duhougan.append('<span class = "time">' + str + '</span>');
                        duhougan.append('<p>' + json.forumPosts.dataList[i].postContent + '</p>');
                        break;
                    case '绘画':
                        huihua.append('<span class = "type hhua">' + json.forumPosts.dataList[i].postType + '</span>');
                        huihua.append('<span class = "title" id="' + json.forumPosts.dataList[i].topicId + '">' + json.forumPosts.dataList

                            [i].postTitle + '</span>');
                        huihua.append('<span class = "time">' + str + '</span>');
                        huihua.append('<img class="pic" src=' + json.forumPosts.dataList[i].fileUrl + '>');
                        huihua.append('<p>' + json.forumPosts.dataList[i].postContent + '</p>');
                        break;
                    case '思维导图':
                        siwei.append('<span class = "type siweit">' + json.forumPosts.dataList[i].postType + '</span>');
                        siwei.append('<span class = "title" id="' + json.forumPosts.dataList[i].topicId + '">' + json.forumPosts.dataList

                            [i].postTitle + '</span>');
                        siwei.append('<span class = "time">' + str + '</span>');
                        siwei.append('<img class="pic" src=' + json.forumPosts.dataList[i].fileUrl + '>');
                        siwei.append('<p>' + json.forumPosts.dataList[i].postContent + '</p>');
                        break;
                    case '读书笔记':
                        note.append('<span class = "type note">' + json.forumPosts.dataList[i].postType + '</span>');
                        note.append('<span class = "title" id="' + json.forumPosts.dataList[i].topicId + '">' + json.forumPosts.dataList

                            [i].postTitle + '</span>');
                        note.append('<span class = "time">' + str + '</span>');
                        note.append('<img class="pic" src=' + json.forumPosts.dataList[i].fileUrl + '>');
                        note.append('<p>' + json.forumPosts.dataList[i].postContent + '</p>');
                        break;
                    case '朗读':
                        langsong.append('<span class = "type lang">' + json.forumPosts.dataList[i].postType + '</span>');
                        langsong.append('<span class = "title" id="' + json.forumPosts.dataList[i].topicId + '">' + json.forumPosts.dataList

                            [i].postTitle + '</span>');
                        langsong.append('<span class = "time">' + str + '</span>');
                        langsong.append('<audio class="vc" src=' + json.forumPosts.dataList[i].fileUrl + ' controls="controls"></audio>');
// langsong.append('<p>' + json.forumPosts.dataList[i].postContent + '</p>');
                        break;
                    case '背诵':
                        beisong.append('<span class = "type bei">' + json.forumPosts.dataList[i].postType + '</span>');
                        beisong.append('<span class = "title" id="' + json.forumPosts.dataList[i].topicId + '">' + json.forumPosts.dataList

                            [i].postTitle + '</span>');
                        beisong.append('<span class = "time">' + str + '</span>');
                        beisong.append('<audio class="vc" src=' + json.forumPosts.dataList[i].fileUrl + ' controls="controls"></audio>');
// beisong.append('<p>' + json.forumPosts.dataList[i].postContent + '</p>');
                        break;
                    default:
                        break;
                }
                //
            }
            // 书名显示
            stringTo();

            function stringTo() {
                bookslength = json.books.length;
                var topicId = [],
                    bookstopicId = [];
                for (var i = 0; i < datalistlength; i++) { // 获取每条评论的topicId
                    topicId.push(json.forumPosts.dataList[i].topicId);
                }
                for (var j = 0; j < bookslength; j++) { // 获取每本书的topicId
                    bookstopicId.push(json.books[j].topicId);
                }
                // 判断是否相等
                // console.log(booktopicId);
                for (var j = 0; j < datalistlength; j++) {
                    for (var i = 0; i < bookstopicId.length; i++) {
                        if ($(".title").eq(j).attr("id") == json.books[i].topicId) {
                            $(".title").eq(j).prepend("《" + json.books[i].name + "》");
                        }
                    }
                }
            } // end 书名显示
            // 获取a的Class属性
            var classlist = [],
                namelist = {}
            mainType = $('.mainType');
            $('.all').addClass('current');
            for (var i = 0; i < ($('.mainType a').length); i++) {
                classlist.push($('.mainType a')[i].className);
                namelist[$('.mainType a')[i].text] = $('.mainType a')[i].className;
            }
            var isdatiClick=0;//答题的点击事件判断
            mainType.find("a").click(function (event) {
                // $('.main-posts ul').find("div").remove();//移除，再点击就不会重复出现
                $('.mainType a').removeClass('current'); // 高亮显示，先移除
                $(event.target).addClass('current'); // 后显示
                switch ($(event.target).text()) {
                    case '全部':
                        $('.main-posts h2').css({
                            'display': 'none',
                        });
                        $('.main-posts div').css({
                            'display': 'none',
                        });
                        $(pinglun).css({
                            'display': 'block',
                        });
                        $(huihua).css({
                            'display': 'block',
                        });
                        $(duhougan).css({
                            'display': 'block',
                        });
                        $(siwei).css({
                            'display': 'block',
                        });
                        $(note).css({
                            'display': 'block',
                        });
                        $(langsong).css({
                            'display': 'block',
                        });
                        $(beisong).css({
                            'display': 'block',
                        });
                        break;
                    case '短评':
                        $('.main-posts h2').css({
                            'display': 'none',
                        });
                        $('.main-posts div').css({
                            'display': 'none',
                        });
                        $(pinglun).css({
                            'display': 'block',
                        });
                        $(huihua).css({
                            'display': 'none',
                        });
                        $(duhougan).css({
                            'display': 'none',
                        });
                        $(siwei).css({
                            'display': 'none',
                        });
                        $(note).css({
                            'display': 'none',
                        });
                        $(langsong).css({
                            'display': 'none',
                        });
                        $(beisong).css({
                            'display': 'none',
                        });
                        break;
                    case '读后感':
                        $('.main-posts h2').css({
                            'display': 'none',
                        });
                        $('.main-posts div').css({
                            'display': 'none',
                        });
                        $(duhougan).css({
                            'display': 'block',
                        });
                        $(pinglun).css({
                            'display': 'none',
                        });
                        $(huihua).css({
                            'display': 'none',
                        });
                        $(siwei).css({
                            'display': 'none',
                        });
                        $(note).css({
                            'display': 'none',
                        });
                        $(langsong).css({
                            'display': 'none',
                        });
                        $(beisong).css({
                            'display': 'none',
                        });
                        break;
                    case '绘画':
                        $('.main-posts h2').css({
                            'display': 'none',
                        });
                        $('.main-posts div').css({
                            'display': 'none',
                        });
                        $(huihua).css({
                            'display': 'block',
                        });
                        $(pinglun).css({
                            'display': 'none',
                        });
                        $(duhougan).css({
                            'display': 'none',
                        });
                        $(siwei).css({
                            'display': 'none',
                        });
                        $(note).css({
                            'display': 'none',
                        });
                        $(langsong).css({
                            'display': 'none',
                        });
                        $(beisong).css({
                            'display': 'none',
                        });
                        break;
                    case '思维导图':
                        $('.main-posts h2').css({
                            'display': 'none',
                        });
                        $('.main-posts div').css({
                            'display': 'none',
                        });
                        $(siwei).css({
                            'display': 'block',
                        });
                        $(pinglun).css({
                            'display': 'none',
                        });
                        $(duhougan).css({
                            'display': 'none',
                        });
                        $(huihua).css({
                            'display': 'none',
                        });
                        $(note).css({
                            'display': 'none',
                        });
                        $(langsong).css({
                            'display': 'none',
                        });
                        $(beisong).css({
                            'display': 'none',
                        });
                        break;
                    case '读书笔记':
                        $('.main-posts h2').css({
                            'display': 'none',
                        });
                        $('.main-posts div').css({
                            'display': 'none',
                        });
                        $(note).css({
                            'display': 'block',
                        });
                        $(pinglun).css({
                            'display': 'none',
                        });
                        $(duhougan).css({
                            'display': 'none',
                        });
                        $(huihua).css({
                            'display': 'none',
                        });
                        $(siwei).css({
                            'display': 'none',
                        });
                        $(langsong).css({
                            'display': 'none',
                        });
                        $(beisong).css({
                            'display': 'none',
                        });
                        break;
                    case '朗读':
                        $('.main-posts h2').css({
                            'display': 'none',
                        });
                        $('.main-posts div').css({
                            'display': 'none',
                        });
                        $(langsong).css({
                            'display': 'block',
                        });
                        $(pinglun).css({
                            'display': 'none',
                        });
                        $(duhougan).css({
                            'display': 'none',
                        });
                        $(huihua).css({
                            'display': 'none',
                        });
                        $(siwei).css({
                            'display': 'none',
                        });
                        $(note).css({
                            'display': 'none',
                        });
                        $(beisong).css({
                            'display': 'none',
                        });
                        break;
                    case '背诵':
                        $('.main-posts h2').css({
                            'display': 'none',
                        });
                        $('.main-posts div').css({
                            'display': 'none',
                        });
                        $(beisong).css({
                            'display': 'block',
                        });
                        $(pinglun).css({
                            'display': 'none',
                        });
                        $(duhougan).css({
                            'display': 'none',
                        });
                        $(huihua).css({
                            'display': 'none',
                        });
                        $(siwei).css({
                            'display': 'none',
                        });
                        $(note).css({
                            'display': 'none',
                        });
                        $(langsong).css({
                            'display': 'none',
                        });
                        break;
                    // case '答题情况':
                    //     if(!isdatiClick){
                    //         $('.main-posts').append('<h2>点击书籍查看该学生的答题情况</h2>');
                    //         $('.main-posts').append('<div class="booksimg"></div>');
                    //         for (var i = 0; i < json.books.length; i++) {
                    //             $('.booksimg').append('<a href="#"id=' + json.books[i].id + ' target="_blank"><img  src =' + json.books[i].picUrl + '></a>');
                    //         }
                    //         var booksimgList = $(".booksimg");
                    //         booksimgList.find("a").click(function (event) {
                    //             // 增加a的href属性
                    //             var href = $(this).attr('href');
                    //             var id = $(this).attr('id');
                    //             // 获取答题明细传入ID\answerDetail.jsp
                    //             $(this).prop('href', path + '/bookq/history/query?bookId=' + id + '&studentId=' + studentId + '&questionType=' +
                    //
                    //                 "single" + '&isCorrect=' + true + '');
                    //         }); // end click
                    //         isdatiClick=1;//答题限制只能append一次。
                    //     }else{
                    //         $('.main-posts h2').css({
                    //             'display': 'block',
                    //         });
                    //         $('.main-posts div').css({
                    //             'display': 'flex',
                    //         });
                    //     }
                    //     $('.beisong').css({
                    //         'display': 'none',
                    //     });
                    //     $('.pinglun').css({
                    //         'display': 'none',
                    //     });
                    //     $('.duhougan').css({
                    //         'display': 'none',
                    //     });
                    //     $('.huihua').css({
                    //         'display': 'none',
                    //     });
                    //     $('.siwei').css({
                    //         'display': 'none',
                    //     });
                    //     $('.biji').css({
                    //         'display': 'none',
                    //     });
                    //     $('.langsong').css({
                    //         'display': 'none',
                    //     });
                    //     break;
                    default:
                        break;
                }

            });
        }, // end of success
        error: function () {
            alert('error' + data.code);
            return false;
        },
    }); // end of Ajax
}

// 展开收起较长评论修改
function conComment() {
    var comments = $('.main-posts ul li p');
    comments.each(function () {
        // 帖子内容超过一定宽度出现展开按钮
        if (height > 84) {
            var commentToggle = $(this).parent().siblings('.post-footer').find('.open');
            commentToggle.css({
                'display': 'inline-block',
            });
            commentToggle.open = false;
            commentToggle.click(function (event) {
                $(element).toggleClass('autoHeight');
                if (this.open === false) {
                    $(this).text('展开');
                    this.open = true;
                } else {
                    $(this).text('收起');
                    this.open = false;
                }
            });
        }
    });
};

// 关闭详情页
$(".backTo").click(function () {
    $(".popup").hide();
    $(".Tcompletion").slideUp();
    $("body").css("overflow", "auto");
    window.location.reload();
});