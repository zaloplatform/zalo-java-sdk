# Zalo SDK for Java (v1.1.0)

## Hướng dẫn sử dụng Social API
**Create an instance of the Zalo class**
```java
long appId = 0l; // put your app id here
String secretKey = "put_your_app_secret_key_here";
String callBackUrl = "put_your_call_back_url_here"
Zalo3rdAppInfo appInfo = new Zalo3rdAppInfo(appId, secretKey, callBackUrl);
Zalo3rdAppClient sdk = new Zalo3rdAppClient(appInfo);
```

**Lấy LoginUrl**
```java
String loginUrl = sdk.getLoginUrl();
```

**Lấy AccessToken**
```java
String code = "put_your_oauth_code_here";
JsonObject accessToken = sdk.getAccessToken(code);
String accessToken = accessToken.get("access_token").getAsString();
int expiresIn = accessToken.get("expires_in").getAsInt();
```

**Thông tin người dùng**
```java
String accessToken = "put_your_access_token_here";
String params = "id,name,picture.type(large),gender,birthday";
JsonObject profile = sdk.getProfile(accessToken, params);
```

**Danh sách bạn bè**
```java
String accessToken = "put_your_access_token_here";
String params = "id,name,picture.type(large),gender,birthday";
int offset = 0; // start index
int count = 10; // total record you want get
JsonObject friends =  sdk.getFriends(accessToken, offset, count, params);
```

**Danh sách bạn bè có thể được mời sử dụng ứng dụng**
```java
String accessToken = "put_your_access_token_here";
String params = "id,name,picture.type(large),gender,birthday";
int offset = 0; // start index
int count = 100; // total record you want get
JsonObject invitableFriends = sdk.getInvitableFriends(accessToken, offset, count, params);
```

**Đăng bài viết**
```java
String accessToken = "put_your_access_token_here";
String textShare = "put_your_text_here";
String linkShare = "put_your_link_here";
JsonObject postFeed =  sdk.postFeed(accessToken, textShare, linkShare);
```

**Mời sử dụng ứng dụng**
```java
String accessToken = "put_your_access_token_here";
String text = "put_your_text_here";
String linkShare = "put_your_link_here";
JsonObject sendAppRequest = sdk.sendAppRequest(accessToken, Arrays.asList(3241414134132l), text);
```

**Gởi tin nhắn tới bạn bè**
```java
String accessToken = "put_your_access_token_here";
long userId = 0l; // put your friends uid here
String textMessage = "put_your_message_here";
String link = "put_your_link_here";
JsonObject sendMessage = sdk.sendMessage(accessToken, userId, textMessage, link);
```

## Hướng dẫn sử dụng Official Account Open API
### Zalo Official Account API
**Create an instance of the Zalo OA class**
```java
long oaid = 0l; // put your oaid here
String secrect = "put_your_oa_secret_key_here";
ZaloOaInfo info = new ZaloOaInfo(oaid, secrect);
ZaloOaClient oaClient = new ZaloOaClient(info);
```

**Lấy thông tin người theo dõi**
```java
long userId = 0l // user id or phone number;
JsonObject profile = oaClient.getProfile(userId);
```

**Gửi tin nhắn text**
```java
long userId = 0l // user id;
String message = "Zalo Java SDK Test Message";
JsonObject ret = oaClient.sendTextMessage(userId, message);
```

**Lấy trạng thái tin nhắn**
```java
String msgid = "message id";
JsonObject ret = oaClient.getMessageStatus(msgid);
```

**Upload hình ảnh**
```java
String fileUrl = "url of file you want to upload or absolute file path";
JsonObject ret = oaClient.uploadPhoto(fileUrl);
```

**Upload ảnh Gìf**
```java
String fileUrl = "url of file you want to upload or absolute file path";
JsonObject ret = oaClient.uploadGifPhoto(fileUrl);
```

**Gửi tin nhắn hình**
```java
long userId = 0l // user id;
MsgImage image = new MsgImage();
image.setImageid("imageid");
image.setMessage("Zalo Java SDK");
JsonObject ret = oaClient.sendImageMessage(userId, image);
```

**Gửi tin nhắn ảnh Gif**
```java
long userId = 0l // user id;
MsgGif gif = new MsgGif();
gif.setImageid("imageid");
gif.setHeight(100);
gif.setWidth(100);
JsonObject ret = oaClient.sendGifMessage(userId, gif);
```

**Gửi tin nhắn dạng liên kết**
```java
long userId = 0l // user id;
MsgLink link = new MsgLink();
link.setLink("https://developers.zalo.me/");
link.setLinkdes("Document For Developers");
link.setLinkthumb("https://developers.zalo.me/web/static/images/bg.jpg");
link.setLinktitle("Zalo For Developers");
JsonObject ret = oaClient.sendLinkMessage(userId, Arrays.asList(link));
```

**Gửi tin nhắn tương tác**
```java
long userId = 0l // user id;
MsgAction action = new OpenInAppAction();
action.setTitle("Send interactive messages");
action.setDescription("This is a test for API send interactive messages");
action.setThumb("https://developers.zalo.me/web/static/images/bg.jpg");

JsonObject popup = new JsonObject();
popup.addProperty("title", "Open Website Zalo For Developers");
popup.addProperty("desc", "Click ok to visit Zalo For Developers and read more Document");
popup.addProperty("ok", "ok");
popup.addProperty("cancel", "cancel");
action.setPopup(popup);

JsonObject ret  =  oaClient.sendActionMessage(userId, Arrays.asList(action));
```

**Gửi tin nhắn chăm sóc khách hàng tới số điện thoại**
```java
String phone = "";
String templateId = "";
JsonObject templateData = new JsonObject();
templateData.addProperty("content", "This is a test for API send  a customer support message to the phone number");
JsonObject ret  =  oaClient.sendMessageCustomerCareByPhone(phone, templateId, templateData);
```

**Gửi tin nhắn chăm sóc khách hàng**
```java
long userId = 0l // user id;
String templateId = "";
JsonObject templateData = new JsonObject();
templateData.addProperty("content", "This is a test for API send  a customer support message to user id");
JsonObject ret  =  oaClient.sendMessageCustomerCareByUserId(userId, templateId, templateData);
```

**Gửi tin nhắn Sticker**
```java
long userId = 0l; // user id
String stickerid = ""; // sticker id
JsonObject ret  =  oaClient.sendStickerMessage(userId, stickerid);
```

**Trả lời tin nhắn dạng text**
```java
String msgid = ""; // message id
String message = "";
JsonObject ret  =  oaClient.replyTextMessage(msgid, message);
```

**Trả lời tin nhắn dạng hình**
```java
String msgid = ""; // message id
String imageid = ""; // image id
String message = "";
JsonObject ret  =  oaClient.replyImageMessage(msgid, imageid, message);
```

**Trả lời tin nhắn dạng liên kết**
```java
String msgid = ""; // message id
MsgLink link = new MsgLink();
link.setLink("https://developers.zalo.me/");
link.setLinkdes("Document For Developers");
link.setLinkthumb("https://developers.zalo.me/web/static/images/bg.jpg");
link.setLinktitle("Zalo For Developers");
JsonObject ret  =  oaClient.replyLinksMessage(msgid, Arrays.asList(link));
```

**Tạo QR Code**
```java
String qrdata = "";
int size = 0;
JsonObject ret  =  oaClient.createQRCode(qrdata, size);
```

### Zalo Official Account API Onbehalf
**Create an instance of the Zalo OA class**
```java
long appId = 0l; // put your appid here
String appSecrectKey = "put_your_app_secret_key_here";
String callbackUrl = "put_your_call_back_url_here";
ZaloAppInfo appInfo = new ZaloAppInfo(appId, appSecrectKey, callbackUrl);
ZaloOaClient oaClient = new ZaloOaClient(appInfo);
```

**Cài đặt proxy**
```java
String proxyHost = "";
int proxyPort = 0;
oaClient.setProxy(proxyHost, proxyPort);
```

**Lấy login url**
```java
String url = oaClient.getLoginOAUrl();
```

**Lấy thông tin người theo dõi**
```java
long userId = 0l // user id or phone number;
String accessToken = "put_your_access_token_here";
JsonObject profile = oaClient.getProfile(userId, accessToken);
```

**Lấy thông tin Offical Account**
```java
String accessToken = "put_your_access_token_here";
JsonObject oaInfo = oaClient.getOAInfo(accessToken);
```

**Lấy đoạn hội thoại giữa người quan tâm và OA**
```java
long userId = 0l // user id;
String accessToken = "put_your_access_token_here";
int offset = 0;
int count = 10;
JsonObject conversation = oaClient.getOAConversation(userId, accessToken, offset, count);
```

**Lấy danh sách người quan tâm vừa chat với OA**
```java
String accessToken = "put_your_access_token_here";
int offset = 0;
int count = 10;
JsonObject listRecentChat = oaClient.getOAListRecentChat(accessToken, offset, count);
```

**Upload hình ảnh**
```java
String accessToken = "put_your_access_token_here";
APIConfig.setTempDir("put_your_temporary_directory_here"); // upload from url need this setting
String fileUrl = "url of file you want to upload";
JsonObject uploadByUrl = oaClient.uploadPhotoFromUrl(fileUrl, accessToken);
String filePath = "absolute path of file you want to upload";
JsonObject uploadByPath = oaClient.uploadPhoto(filePath, accessToken);
```

**Upload ảnh Gìf**
```java
String accessToken = "put_your_access_token_here";
APIConfig.setTempDir("put_your_temporary_directory_here"); // upload from url need this setting
String fileUrl = "url of file you want to upload";
JsonObject uploadByUrl = oaClient.uploadGifPhotoFromUrl(fileUrl, accessToken);
String filePath = "absolute path of file you want to upload";
JsonObject uploadByPath = oaClient.uploadGifPhoto(filePath, accessToken);
```

**Gửi tin nhắn text**
```java
long userId = 0l // user id;
String message = "Zalo Java SDK Test Message";
String accessToken = "put_your_access_token_here";
JsonObject ret = oaClient.sendTextMessage(userId, message, accessToken);
```

**Gửi tin nhắn hình**
```java
long userId = 0l // user id;
String accessToken = "put_your_access_token_here";
MsgImage imageMsg = new MsgImage();
imageMsg.setImageid("imageid");
imageMsg.setMessage("Zalo Java SDK");
JsonObject ret = oaClient.sendImageMessage(userId, imageMsg, accessToken);
```

**Gửi tin nhắn ảnh Gif**
```java
long userId = 0l // user id;
String accessToken = "put_your_access_token_here";
MsgGif gifMsg = new MsgGif();
gifMsg.setImageid("imageid");
gifMsg.setHeight(100);
gifMsg.setWidth(100);
JsonObject ret = oaClient.sendGifMessage(userId, gifMsg, accessToken);
```

**Gửi tin nhắn dạng liên kết**
```java
long userId = 0l // user id;
String accessToken = "put_your_access_token_here";
MsgLink link = new MsgLink();
link.setLink("https://developers.zalo.me/");
link.setLinkdes("Document For Developers");
link.setLinkthumb("https://developers.zalo.me/web/static/images/bg.jpg");
link.setLinktitle("Zalo For Developers");
List<MsgLink> links = Arrays.asList(link);
JsonObject ret = oaClient.sendLinkMessage(userId, links, accessToken);
```

**Gửi tin nhắn tương tác**
```java
long userId = 0l // user id;
String accessToken = "put_your_access_token_here";
MsgAction action = new OpenInAppAction();
action.setTitle("Send interactive messages");
action.setDescription("This is a test for API send interactive messages");
action.setThumb("https://developers.zalo.me/web/static/images/bg.jpg");
JsonObject popup = new JsonObject();
popup.addProperty("title", "Open Website Zalo For Developers");
popup.addProperty("desc", "Click ok to visit Zalo For Developers and read more Document");
popup.addProperty("ok", "ok");
popup.addProperty("cancel", "cancel");
action.setPopup(popup);
List<MsgAction> actions = Arrays.asList(action);
JsonObject ret  =  oaClient.sendActionMessage(userId, actions, accessToken);
```

**Gửi tin nhắn Sticker**
```java
long userId = 0l; // user id
String accessToken = "put_your_access_token_here";
String stickerId = ""; // sticker id
JsonObject ret  =  oaClient.sendStickerMessage(userId, stickerId, accessToken);
```

**Trả lời tin nhắn dạng text**
```java
String msgid = ""; // message id
String accessToken = "put_your_access_token_here";
String message = "";
JsonObject ret  =  oaClient.replyTextMessage(msgId, message, accessToken);
```

**Trả lời tin nhắn dạng hình**
```java
String msgid = ""; // message id
String accessToken = "put_your_access_token_here";
MsgImage imageMsg = new MsgImage();
imageMsg.setImageid("put_image_id_here");
imageMsg.setMessage("put_message_here");
JsonObject ret  =  oaClient.replyImageMessage(msgId, imageMsg, accessToken);
```

**Trả lời tin nhắn dạng liên kết**
```java
String msgid = ""; // message id
String accessToken = "put_your_access_token_here";
MsgLink link = new MsgLink();
link.setLink("https://developers.zalo.me/");
link.setLinkdes("Document For Developers");
link.setLinkthumb("https://developers.zalo.me/web/static/images/bg.jpg");
link.setLinktitle("Zalo For Developers");
List<MsgLink> links = Arrays.asList(link);
JsonObject ret  =  oaClient.replyLinksMessage(msgId, links, accessToken);
```

## Hướng dẫn sử dụng Official Account Article API
### Zalo Official Account API
**Create an instance of the Zalo OA class**
```java
long oaid = 0l; // put your oaid here
String secrect = "put_your_oa_secret_key_here";
ZaloOaInfo info = new ZaloOaInfo(oaid, secrect);
ZaloOaClient oaClient = new ZaloOaClient(info);
```

**Lấy danh sách bài viết**
```java
int start = 0;
int offset = 10;
JsonObject listArticle = oaClient.getSliceArticle(start, offset);
```

**Upload video cho bài viết**
```java
// Upload file
File file = new File("path/to/your/video");
String mediaId = oaClient.uploadVideoArticle(file);
// Upload bằng link
mediaId = oaClient.uploadVideoArticleFromURL("https://link.to.your.video");
```

**Broadcast bài viết**
```java
JsonObject mediaId_1 = new JsonObject();
JsonObject mediaId_2 = new JsonObject();
JsonObject mediaId_3 = new JsonObject();
JsonObject mediaId_4 = new JsonObject();
JsonObject mediaId_5 = new JsonObject();

mediaId_1.addProperty("id", "d898241b025eeb00b24f");
mediaId_2.addProperty("id", "a63f01af25eaccb495fb");
mediaId_3.addProperty("id", "3dc70c162853c10d9842");
mediaId_4.addProperty("id", "682558f47cb195efcca0");
mediaId_5.addProperty("id", "c883e999c2dc2b8272cd");
            
// Build mediaIds data
JsonArray mediaIds = new JsonArray();
mediaIds.add(mediaId_1);
mediaIds.add(mediaId_2);
mediaIds.add(mediaId_3);
mediaIds.add(mediaId_4);
mediaIds.add(mediaId_5);

// Build target data            
JsonObject target = new JsonObject();
target.addProperty("ages", "0,1,2,3,4,5,6,7");
target.addProperty("gender", "0");
target.addProperty("locations", "0,1,2");
target.addProperty("cities", "4,9");
target.addProperty("platforms", "1,2,3");
target.addProperty("telcos", "1,2,3,4");

JsonObject params = new JsonObject();
params.add("mediaIds", mediaIds);
params.add("target", target);

JsonObject broadcastArticle = oaClient.broadcastArticle(params);
```

**Xóa bài viết**
```java
String mediaId = "put_media_id_here";
JsonObject result = oaClient.oaClient.removeArticle(mediaId);
```

**Lấy Id của bài viết**
```java
String token = "put_token_here";
JsonObject result = oaClient.getMediaId(token);
```

**Tạo bài viết**
```java
String title = "put_title_here";
String author = "put_author_here";
String desc = "put_description_here";
JsonObject cover = new JsonObject();

// Sử dụng nếu cover là image
// cover.addProperty("coverType", 0);
// cover.addProperty("photoUrl", "");

// Sử dụng nếu cover là video
cover.addProperty("coverType", 1); // video
cover.addProperty("videoId", "put_media_id_here");
cover.addProperty("coverView", 1); // ngang
cover.addProperty("status", "show");

JsonObject actionLink = new JsonObject();
actionLink.addProperty("type", 0);
actionLink.addProperty("label", "put_label_here");
actionLink.addProperty("url", "http://www.google.com");

JsonObject paragraphText = new JsonObject();
paragraphText.addProperty("type", 0);
paragraphText.addProperty("content", "put_content_here");

// Sử dụng nếu add image vào body
// JsonObject paragraphImage = new JsonObject();
// paragraphImage.addProperty("type", 1);
// paragraphImage.addProperty("url", "");
// paragraphImage.addProperty("caption", "image");              
// paragraphImage.addProperty("width", 640);                   
// paragraphImage.addProperty("height", (int) (640 / 9 * 6));

JsonObject paragraphVideo = new JsonObject();
// Su dung neu add video youtube vao body
paragraphVideo.addProperty("type", 3);
paragraphVideo.addProperty("category", "youtube");
paragraphVideo.addProperty("url", "https://www.youtube.com/watch?v=jp3xBWgii8A");

// Sử dụng nếu add video vào body
// paragraphVideo.addProperty("category", "direct");
// paragraphVideo.addProperty("url", "put_link_here");

// Su dung neu add video da upload
// paragraphVideo.addProperty("category", "file");
// paragraphVideo.addProperty("videoId", "put_media_id_here");
// paragraphVideo.addProperty("caption", "put_caption_here");
// paragraphVideo.addProperty("thumb", "put_thumbnail_here");

JsonArray body = new JsonArray();
body.add(paragraphText);
body.add(paragraphVideo);
// body.add(paragraphImage);

JsonArray medias = new JsonArray();
JsonObject relateMedia = new JsonObject();
relateMedia.addProperty("id", "put_relate_media_id_here");
medias.add(relateMedia);

JsonObject article = new JsonObject();
article.addProperty("title", title);
article.addProperty("author", author);
article.add("cover", cover);
article.addProperty("desc", desc);
article.addProperty("status", "show");
article.add("actionLink", actionLink);
article.add("body", body);
article.add("relatedMedias", medias);
JsonObject result = oaClient.createArticle(article);
```

**Chỉnh sửa bài viết**
```java
String title = "put_title_here";
String author = "put_author_here";
String desc = "put_description_here";
JsonObject cover = new JsonObject();

cover.addProperty("coverType", 1); // video
cover.addProperty("videoId", "put_media_id_here");
cover.addProperty("coverView", 1); // ngang
cover.addProperty("status", "show");

JsonObject actionLink = new JsonObject();
actionLink.addProperty("type", 0);
actionLink.addProperty("label", "put_label_here");
actionLink.addProperty("url", "http://www.google.com");

JsonObject paragraphText = new JsonObject();
paragraphText.addProperty("type", 0);
paragraphText.addProperty("content", "put_content_here");

JsonObject paragraphVideo = new JsonObject();
paragraphVideo.addProperty("type", 3);
paragraphVideo.addProperty("category", "youtube");
paragraphVideo.addProperty("url", "https://www.youtube.com/watch?v=jp3xBWgii8A");

JsonArray body = new JsonArray();
body.add(paragraphText);
body.add(paragraphVideo);

JsonArray medias = new JsonArray();
JsonObject relateMedia = new JsonObject();
relateMedia.addProperty("id", "put_relate_media_id_here");
medias.add(relateMedia);

JsonObject article = new JsonObject();
article.addProperty("title", title);
article.addProperty("author", author);
article.add("cover", cover);
article.addProperty("desc", desc);
article.addProperty("status", "show");
article.add("actionLink", actionLink);
article.add("body", body);
article.add("relatedMedias", medias);

JsonObject updateData = new JsonObject();
updateData.addProperty("mediaid", "put_media_id_here");
updateData.add("media", article);
JsonObject result = oaClient.updateMediaArticle(updateData);
```

**Tạo bài viết video**
```java
JsonObject videoArticle = new JsonObject();
videoArticle.addProperty("title", "video_article_title");
videoArticle.addProperty("desc", "put_your_description_here");
videoArticle.addProperty("status", "show"); // show | hide
videoArticle.addProperty("videoId", "put_video_id_here"); // sử dụng api upload video để lấy videoId
videoArticle.addProperty("avatar", "put_video_thumbnail_here");
JsonObject media = new JsonObject();
media.addProperty("id", "put_media_id_here");
JsonArray relatedMedias = new JsonArray();
relatedMedias.add(media);
videoArticle.add("relatedMedias", relatedMedias);
JsonObject createVideoArticle = oaClient.createVideoArticle(videoArticle);
```

**Chỉnh sửa bài viết video**
```java
JsonObject videoArticle = new JsonObject();
videoArticle.addProperty("title", "video_article_title");
videoArticle.addProperty("desc", "put_your_description_here");
videoArticle.addProperty("status", "show"); // show | hide
videoArticle.addProperty("videoId", "put_video_id_here"); // sử dụng api upload video để lấy videoId
videoArticle.addProperty("avatar", "put_video_thumbnail_here");
JsonObject media = new JsonObject();
media.addProperty("id", "put_media_id_here");
JsonArray relatedMedias = new JsonArray();
relatedMedias.add(media);
videoArticle.add("relatedMedias", relatedMedias);

JsonObject videoData = new JsonObject();
videoData.addProperty("mediaid", "put_media_id_here");
videoData.add("media", videoArticle);
JsonObject updateVideoArticle = oaClient.updateVideoArticle(videoData);
System.out.println(updateVideoArticle);
```

## Versioning

Current version is 1.1.0. We will update more features in next version.

## Authors

* **Zalo's developers** 

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details
# zalo-java-sdk
