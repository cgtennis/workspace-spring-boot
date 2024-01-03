function main() 
{
    console.log("nicks-cors-test");
    $.ajax
    ({
        url: "http://localhost:8080/api/coffee",
        success: function(data) 
        {
            console.log(data);
        }
    });
}