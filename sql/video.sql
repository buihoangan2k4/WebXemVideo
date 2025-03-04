USE [asmJava4]
GO
/****** Object:  Table [dbo].[history]    Script Date: 8/21/2024 6:37:55 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[history](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[userId] [int] NULL,
	[videoId] [int] NULL,
	[viewedDate] [datetime] NOT NULL,
	[isLiked] [bit] NOT NULL,
	[likeDate] [datetime] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[users]    Script Date: 8/21/2024 6:38:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[users](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[username] [varchar](10) NOT NULL,
	[password] [varchar](10) NOT NULL,
	[email] [varchar](50) NOT NULL,
	[isAdmin] [bit] NOT NULL,
	[isActive] [bit] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[video]    Script Date: 8/21/2024 6:38:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[video](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[title] [nvarchar](255) NOT NULL,
	[href] [varchar](50) NOT NULL,
	[poster] [varchar](255) NOT NULL,
	[views] [int] NOT NULL,
	[shares] [int] NOT NULL,
	[description] [nvarchar](255) NULL,
	[isActive] [bit] NOT NULL,
 CONSTRAINT [PK__video__3213E83F510B6EF4] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[history] ON 

INSERT [dbo].[history] ([id], [userId], [videoId], [viewedDate], [isLiked], [likeDate]) VALUES (4, 2, 6, CAST(N'2024-03-24T17:55:59.883' AS DateTime), 0, NULL)
INSERT [dbo].[history] ([id], [userId], [videoId], [viewedDate], [isLiked], [likeDate]) VALUES (5, 1, 8, CAST(N'2024-03-24T17:55:59.883' AS DateTime), 0, NULL)
INSERT [dbo].[history] ([id], [userId], [videoId], [viewedDate], [isLiked], [likeDate]) VALUES (12, 1, 6, CAST(N'2024-04-03T16:56:28.103' AS DateTime), 0, NULL)
INSERT [dbo].[history] ([id], [userId], [videoId], [viewedDate], [isLiked], [likeDate]) VALUES (13, 1, 7, CAST(N'2024-04-03T16:59:33.177' AS DateTime), 0, NULL)
INSERT [dbo].[history] ([id], [userId], [videoId], [viewedDate], [isLiked], [likeDate]) VALUES (14, 5, 9, CAST(N'2024-04-03T19:04:57.503' AS DateTime), 1, CAST(N'2024-04-03T19:12:01.147' AS DateTime))
INSERT [dbo].[history] ([id], [userId], [videoId], [viewedDate], [isLiked], [likeDate]) VALUES (15, 5, 6, CAST(N'2024-04-03T19:09:16.460' AS DateTime), 1, CAST(N'2024-04-05T10:06:40.553' AS DateTime))
INSERT [dbo].[history] ([id], [userId], [videoId], [viewedDate], [isLiked], [likeDate]) VALUES (16, 5, 7, CAST(N'2024-04-05T10:14:20.747' AS DateTime), 1, CAST(N'2024-04-05T10:14:24.683' AS DateTime))
INSERT [dbo].[history] ([id], [userId], [videoId], [viewedDate], [isLiked], [likeDate]) VALUES (17, 5, 8, CAST(N'2024-04-05T10:14:28.783' AS DateTime), 0, NULL)
INSERT [dbo].[history] ([id], [userId], [videoId], [viewedDate], [isLiked], [likeDate]) VALUES (18, 5, 12, CAST(N'2024-04-05T10:16:48.357' AS DateTime), 1, CAST(N'2024-04-05T10:16:52.577' AS DateTime))
INSERT [dbo].[history] ([id], [userId], [videoId], [viewedDate], [isLiked], [likeDate]) VALUES (19, 8, 7, CAST(N'2024-04-08T07:39:58.307' AS DateTime), 1, CAST(N'2024-04-08T07:40:02.727' AS DateTime))
SET IDENTITY_INSERT [dbo].[history] OFF
GO
SET IDENTITY_INSERT [dbo].[users] ON 

INSERT [dbo].[users] ([id], [username], [password], [email], [isAdmin], [isActive]) VALUES (1, N'anbh', N'123', N'anhoang@gmail,com', 1, 1)
INSERT [dbo].[users] ([id], [username], [password], [email], [isAdmin], [isActive]) VALUES (2, N'bhan20', N'111', N'anhoangbui@gmail,com', 1, 1)
INSERT [dbo].[users] ([id], [username], [password], [email], [isAdmin], [isActive]) VALUES (5, N'testMail', N'123', N'anhoang552005@gmail.com', 0, 1)
INSERT [dbo].[users] ([id], [username], [password], [email], [isAdmin], [isActive]) VALUES (8, N'buihaongan', N'123', N'buian20062004@gmail.com', 0, 1)
SET IDENTITY_INSERT [dbo].[users] OFF
GO
SET IDENTITY_INSERT [dbo].[video] ON 

INSERT [dbo].[video] ([id], [title], [href], [poster], [views], [shares], [description], [isActive]) VALUES (6, N'



Khúc Cửu Môn Hồi Ức - Đẳng Thập Ma Quân / 辞九门回忆 (DJ阿超 Remix) Cổ Phong TikTok', N'fPVY6YlrLI4', N'https://img.youtube.com/vi/fPVY6YlrLI4/maxresdefault.jpg', 0, 0, N'Hãy cùng chúng tôi khám phá v? d?p lãng m?n c?a thành ph? ánh sáng - Paris, Pháp, v?i nh?ng di?m du l?ch n?i ti?ng và các tr?i nghi?m thú v?', 0)
INSERT [dbo].[video] ([id], [title], [href], [poster], [views], [shares], [description], [isActive]) VALUES (7, N'Vong Xuyên Bỉ Ngạn - Linh Nhất Cửu Linh Nhị | 零一九零贰 - 忘川彼岸 (DJ Pad仔 Remix)123', N'1A3MBqQaE68', N'https://img.youtube.com/vi/bbubRw6Puag/maxresdefault.jpg', 0, 0, N'Khám phá 5 bí m?t quan tr?ng mà m?i doanh nhân c?n bi?t d? thành công trong kinh doanh và d?t du?c m?c tiêu c?a mình.', 1)
INSERT [dbo].[video] ([id], [title], [href], [poster], [views], [shares], [description], [isActive]) VALUES (8, N'Mạc Vấn Quy Kỳ 莫问归期 - 蒋雪儿 (DJ 小玉 Remix) TikTok', N'ovmplyvYquM', N'https://img.youtube.com/vi/ovmplyvYquM/maxresdefault.jpg', 0, 0, N'Xem ngay hu?ng d?n chi ti?t cách làm món bánh pizza thom ngon t?i nhà v?i các nguyên li?u don gi?n.', 1)
INSERT [dbo].[video] ([id], [title], [href], [poster], [views], [shares], [description], [isActive]) VALUES (9, N'
Nan Khước Remix Slowed | DJ Tế Lâm Bản Remix | Hot Tiktok Version', N'Ro6oYzTet_I', N'https://img.youtube.com/vi/Ro6oYzTet_I/maxresdefault.jpg', 0, 0, N'T?n hu?ng huong v? d?m dà c?a ?m th?c Ý khi b?n khám phá nh?ng món ngon truy?n th?ng t? thành ph? l?ch s? Rome d?n thành ph? ngh? thu?t Florence, m?t hành trình th?c s? làm say lòng b?t k? ai.', 1)
INSERT [dbo].[video] ([id], [title], [href], [poster], [views], [shares], [description], [isActive]) VALUES (10, N'Xomu - Lanterns', N'W9gO-K7_31M', N'https://img.youtube.com/vi/W9gO-K7_31M/maxresdefault.jpg', 0, 0, NULL, 1)
INSERT [dbo].[video] ([id], [title], [href], [poster], [views], [shares], [description], [isActive]) VALUES (11, N'Star Sky Remix《阳山伟伟 - 星空》(Bầu Trời Đầy Sao)', N'bbubRw6Puag', N'https://img.youtube.com/vi/bbubRw6Puag/maxresdefault.jpg', 0, 0, NULL, 1)
INSERT [dbo].[video] ([id], [title], [href], [poster], [views], [shares], [description], [isActive]) VALUES (12, N'Vexento - Lonely Dance', N'tvQvpIy9JnA', N'https://img.youtube.com/vi/tvQvpIy9JnA/maxresdefault.jpg', 0, 0, NULL, 1)
INSERT [dbo].[video] ([id], [title], [href], [poster], [views], [shares], [description], [isActive]) VALUES (13, N'teas', N'wr', N'https://img.youtube.com/vi/bbubRw6Puag/maxresdefault.jpg', 0, 0, NULL, 0)
INSERT [dbo].[video] ([id], [title], [href], [poster], [views], [shares], [description], [isActive]) VALUES (19, N'Vong Xuyên Bỉ Ngạn - Linh Nhất Cửu Linh Nhị | 零一九零贰 - 忘川彼岸 (DJ Pad仔 Remix)222', N'1A3MBqQaE682222', N'https://img.youtube.com/vi/bbubRw6Puag/maxresdefault.jpg', 0, 0, NULL, 1)
INSERT [dbo].[video] ([id], [title], [href], [poster], [views], [shares], [description], [isActive]) VALUES (20, N'Vong Xuyên Bỉ Ngạn - Linh Nhất Cửu Linh Nhị | 零一九零贰 - 忘川彼岸 (DJ Pad仔 Remix)123', N'1A3MBqQaE681231', N'https://img.youtube.com/vi/bbubRw6Puag/maxresdefault.jpg', 0, 0, NULL, 0)
SET IDENTITY_INSERT [dbo].[video] OFF
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [UQ__user__AB6E616426F9F692]    Script Date: 8/21/2024 6:38:19 PM ******/
ALTER TABLE [dbo].[users] ADD UNIQUE NONCLUSTERED 
(
	[email] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [UQ__user__F3DBC572B5C5A137]    Script Date: 8/21/2024 6:38:19 PM ******/
ALTER TABLE [dbo].[users] ADD UNIQUE NONCLUSTERED 
(
	[username] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [UQ__video__7FF10F0561BE30D1]    Script Date: 8/21/2024 6:38:19 PM ******/
ALTER TABLE [dbo].[video] ADD  CONSTRAINT [UQ__video__7FF10F0561BE30D1] UNIQUE NONCLUSTERED 
(
	[href] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
ALTER TABLE [dbo].[history] ADD  DEFAULT (getdate()) FOR [viewedDate]
GO
ALTER TABLE [dbo].[history] ADD  DEFAULT ((0)) FOR [isLiked]
GO
ALTER TABLE [dbo].[users] ADD  DEFAULT ((0)) FOR [isAdmin]
GO
ALTER TABLE [dbo].[users] ADD  DEFAULT ((1)) FOR [isActive]
GO
ALTER TABLE [dbo].[video] ADD  CONSTRAINT [DF__video__views__5070F446]  DEFAULT ((0)) FOR [views]
GO
ALTER TABLE [dbo].[video] ADD  CONSTRAINT [DF__video__descripti__5165187F]  DEFAULT ((0)) FOR [shares]
GO
ALTER TABLE [dbo].[history]  WITH CHECK ADD FOREIGN KEY([userId])
REFERENCES [dbo].[users] ([id])
GO
ALTER TABLE [dbo].[history]  WITH CHECK ADD  CONSTRAINT [FK__history__videoId__5535A963] FOREIGN KEY([videoId])
REFERENCES [dbo].[video] ([id])
GO
ALTER TABLE [dbo].[history] CHECK CONSTRAINT [FK__history__videoId__5535A963]
GO
/****** Object:  StoredProcedure [dbo].[sp_selectUsersLikedVideoByVideoHref]    Script Date: 8/21/2024 6:38:19 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[sp_selectUsersLikedVideoByVideoHref](@videoHref varchar(50))
as begin
	select u.id, u.username , u.[password], u.email, u.isAdmin, u.isActive
	from users u inner join history h on u.id = h.userId
			inner join video v on h.videoId = v.id 
	where v.href = @videoHref and u.isActive = 1 and v.isActive = 1 and h.isLiked = 1
end
GO
