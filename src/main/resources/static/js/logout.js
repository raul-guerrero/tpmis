$.ajaxSetup({
                beforeSend: function (xhr, settings) {
                    if (settings.type == 'POST' || settings.type == 'PUT'
                        || settings.type == 'DELETE') {
                        if (!(/^http:.*/.test(settings.url) || /^https:.*/.test(settings.url))) {
                            // Only send the token to relative URLs
                            xhr.setRequestHeader("X-XSRF-TOKEN", Cookies.get('XSRF-TOKEN'));
                        }
                    }
                }
            });

$.get("/api/users/me", function (data) {
    $("#user").html(data.userAuthentication.details.name);
    $(".unauthenticated").hide();
    $(".authenticated").show();
});

var logout = function () {
    $.post("/logout", function () {
        $("#user").html('');
        $(".unauthenticated").show();
        $(".authenticated").hide();
    });
    window.location.href = "/";
    return true;
}
