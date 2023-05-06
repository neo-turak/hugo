package com.github.hugo.model


import android.os.Parcelable
import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Keep
@Parcelize
data class ImageModel(
    @SerializedName("alt_description")
    val altDescription: String, // a single pink flower with a white background
    @SerializedName("blur_hash")
    val blurHash: String, // L8RyjMn,.m-=.7ozM_RPy;kBHsV@
    val color: String, // #f3f3f3
    @SerializedName("created_at")
    val createdAt: String, // 2023-04-21T18:25:24Z
    @SerializedName("current_user_collections")
    val currentUserCollections: List<String>?,
    val description: String?, // null
    val downloads: Int, // 2385
    val exif: Exif,
    val height: Int, // 6016
    val id: String, // UVZY9g93fHQ
    @SerializedName("liked_by_user")
    val likedByUser: Boolean, // false
    val likes: Int, // 62
    val links: Links,
    val location: Location,
    val meta: Meta,
    @SerializedName("promoted_at")
    val promotedAt: String, // 2023-04-22T11:31:11Z
    @SerializedName("public_domain")
    val publicDomain: Boolean, // false
    val slug: String, // UVZY9g93fHQ
    val sponsorship: String?, // null
    val tags: List<Tag>,
    @SerializedName("tags_preview")
    val tagsPreview: List<TagsPreview>,
    @SerializedName("topic_submissions")
    val topicSubmissions: TopicSubmissions,
    val topics: List<String>?,
    @SerializedName("updated_at")
    val updatedAt: String, // 2023-05-05T19:35:59Z
    val urls: Urls,
    val user: User,
    val views: Int, // 293402
    val width: Int // 4016
) : Parcelable {
    @Keep
    @Parcelize
    data class Exif(
        val aperture: String, // 8.0
        @SerializedName("exposure_time")
        val exposureTime: String, // 1/800
        @SerializedName("focal_length")
        val focalLength: String, // 50.0
        val iso: Int, // 100
        val make: String, // NIKON CORPORATION
        val model: String, // NIKON D750
        val name: String // NIKON CORPORATION, NIKON D750
    ) : Parcelable

    @Keep
    @Parcelize
    data class Links(
        val download: String, // https://unsplash.com/photos/UVZY9g93fHQ/download?ixid=Mnw0NDQ5NzV8MHwxfHJhbmRvbXx8fHx8fHx8fDE2ODMzNTc2MDY
        @SerializedName("download_location")
        val downloadLocation: String, // https://api.unsplash.com/photos/UVZY9g93fHQ/download?ixid=Mnw0NDQ5NzV8MHwxfHJhbmRvbXx8fHx8fHx8fDE2ODMzNTc2MDY
        val html: String, // https://unsplash.com/photos/UVZY9g93fHQ
        val self: String // https://api.unsplash.com/photos/UVZY9g93fHQ
    ) : Parcelable

    @Keep
    @Parcelize
    data class Location(
        val city: String?, // null
        val country: String?, // null
        val name: String?, // null
        val position: Position
    ) : Parcelable {
        @Keep
        @Parcelize
        data class Position(
            val latitude: Double, // 0.0
            val longitude: Double // 0.0
        ) : Parcelable
    }

    @Keep
    @Parcelize
    data class Meta(
        val index: Boolean // true
    ) : Parcelable

    @Keep
    @Parcelize
    data class Tag(
        val source: Source?,
        val title: String, // flower
        val type: String // landing_page
    ) : Parcelable {
        @Keep
        @Parcelize
        data class Source(
            val ancestry: Ancestry,
            @SerializedName("cover_photo")
            val coverPhoto: CoverPhoto,
            val description: String, // Choose from a curated selection of flower photos. Always free on Unsplash.
            @SerializedName("meta_description")
            val metaDescription: String, // Choose from hundreds of free flower pictures. Download HD flower photos for free on Unsplash.
            @SerializedName("meta_title")
            val metaTitle: String, // 500+ Flower Pictures [HD] | Download Free Images on Unsplash
            val subtitle: String, // Download free flower images
            val title: String // Flower images
        ) : Parcelable {
            @Keep
            @Parcelize
            data class Ancestry(
                val category: Category,
                val subcategory: Subcategory?,
                val type: Type
            ) : Parcelable {
                @Keep
                @Parcelize
                data class Category(
                    @SerializedName("pretty_slug")
                    val prettySlug: String, // Nature
                    val slug: String // nature
                ) : Parcelable

                @Keep
                @Parcelize
                data class Subcategory(
                    @SerializedName("pretty_slug")
                    val prettySlug: String, // Flower
                    val slug: String // flower
                ) : Parcelable

                @Keep
                @Parcelize
                data class Type(
                    @SerializedName("pretty_slug")
                    val prettySlug: String, // Images
                    val slug: String // images
                ) : Parcelable
            }

            @Keep
            @Parcelize
            data class CoverPhoto(
                @SerializedName("alt_description")
                val altDescription: String, // pink rose flower
                @SerializedName("blur_hash")
                val blurHash: String, // L6R{lY-;_N%MtRofIUogtlofMwWB
                val color: String, // #f3f3f3
                @SerializedName("created_at")
                val createdAt: String, // 2017-08-15T15:10:43Z
                @SerializedName("current_user_collections")
                val currentUserCollections: List<String>?,
                val description: String?, // It’s a personal opinion of mine that the more a flower fades, the more beautiful it becomes.
                val height: Int, // 4119
                val id: String, // fsdWYNTymjI
                @SerializedName("liked_by_user")
                val likedByUser: Boolean, // false
                val likes: Int, // 2842
                val links: Links,
                val plus: Boolean, // false
                val premium: Boolean, // false
                @SerializedName("promoted_at")
                val promotedAt: String, // 2017-08-16T15:26:28Z
                val sponsorship: String?, // null
                @SerializedName("topic_submissions")
                val topicSubmissions: TopicSubmissions?,
                @SerializedName("updated_at")
                val updatedAt: String, // 2023-04-30T10:01:49Z
                val urls: Urls,
                val user: User,
                val width: Int // 2942
            ) : Parcelable {
                @Keep
                @Parcelize
                data class Links(
                    val download: String, // https://unsplash.com/photos/fsdWYNTymjI/download
                    @SerializedName("download_location")
                    val downloadLocation: String, // https://api.unsplash.com/photos/fsdWYNTymjI/download
                    val html: String, // https://unsplash.com/photos/fsdWYNTymjI
                    val self: String // https://api.unsplash.com/photos/fsdWYNTymjI
                ) : Parcelable

                @Keep
                @Parcelize
                data class TopicSubmissions(
                    val animals: Animals?,
                    val wallpapers: Wallpapers?
                ) : Parcelable {
                    @Keep
                    @Parcelize
                    data class Animals(
                        @SerializedName("approved_on")
                        val approvedOn: String, // 2020-04-27T11:45:14Z
                        val status: String // approved
                    ) : Parcelable

                    @Keep
                    @Parcelize
                    data class Wallpapers(
                        @SerializedName("approved_on")
                        val approvedOn: String, // 2021-09-13T17:13:46Z
                        val status: String // approved
                    ) : Parcelable
                }

                @Keep
                @Parcelize
                data class Urls(
                    val full: String, // https://images.unsplash.com/photo-1502809737437-1d85c70dd2ca?ixlib=rb-4.0.3&q=85&fm=jpg&crop=entropy&cs=srgb
                    val raw: String, // https://images.unsplash.com/photo-1502809737437-1d85c70dd2ca?ixlib=rb-4.0.3
                    val regular: String, // https://images.unsplash.com/photo-1502809737437-1d85c70dd2ca?ixlib=rb-4.0.3&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=1080&fit=max
                    val small: String, // https://images.unsplash.com/photo-1502809737437-1d85c70dd2ca?ixlib=rb-4.0.3&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=400&fit=max
                    @SerializedName("small_s3")
                    val smallS3: String, // https://s3.us-west-2.amazonaws.com/images.unsplash.com/small/photo-1502809737437-1d85c70dd2ca
                    val thumb: String // https://images.unsplash.com/photo-1502809737437-1d85c70dd2ca?ixlib=rb-4.0.3&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=200&fit=max
                ) : Parcelable

                @Keep
                @Parcelize
                data class User(
                    @SerializedName("accepted_tos")
                    val acceptedTos: Boolean, // true
                    val bio: String?, // Hi! I’m Tanalee. I'm a Believer, a wife, a mom, a US Army Veteran, a carpenter, a graphic designer, a photographer.  I AM a creative! 
                    @SerializedName("first_name")
                    val firstName: String, // Tanalee
                    @SerializedName("for_hire")
                    val forHire: Boolean, // false
                    val id: String, // AZlDcT0kEKM
                    @SerializedName("instagram_username")
                    val instagramUsername: String, // theheartdept
                    @SerializedName("last_name")
                    val lastName: String, // Youngblood
                    val links: Links,
                    val location: String?, // Northern Kentucky
                    val name: String, // Tanalee Youngblood
                    @SerializedName("portfolio_url")
                    val portfolioUrl: String?, // null
                    @SerializedName("profile_image")
                    val profileImage: ProfileImage,
                    val social: Social,
                    @SerializedName("total_collections")
                    val totalCollections: Int, // 5
                    @SerializedName("total_likes")
                    val totalLikes: Int, // 60
                    @SerializedName("total_photos")
                    val totalPhotos: Int, // 18
                    @SerializedName("twitter_username")
                    val twitterUsername: String?, // at8eqeq3
                    @SerializedName("updated_at")
                    val updatedAt: String, // 2023-04-15T11:43:04Z
                    val username: String // theheartdept
                ) : Parcelable {
                    @Keep
                    @Parcelize
                    data class Links(
                        val followers: String, // https://api.unsplash.com/users/theheartdept/followers
                        val following: String, // https://api.unsplash.com/users/theheartdept/following
                        val html: String, // https://unsplash.com/it/@theheartdept
                        val likes: String, // https://api.unsplash.com/users/theheartdept/likes
                        val photos: String, // https://api.unsplash.com/users/theheartdept/photos
                        val portfolio: String, // https://api.unsplash.com/users/theheartdept/portfolio
                        val self: String // https://api.unsplash.com/users/theheartdept
                    ) : Parcelable

                    @Keep
                    @Parcelize
                    data class ProfileImage(
                        val large: String, // https://images.unsplash.com/profile-1502809342539-1dd464200dd4?ixlib=rb-4.0.3&crop=faces&fit=crop&w=128&h=128
                        val medium: String, // https://images.unsplash.com/profile-1502809342539-1dd464200dd4?ixlib=rb-4.0.3&crop=faces&fit=crop&w=64&h=64
                        val small: String // https://images.unsplash.com/profile-1502809342539-1dd464200dd4?ixlib=rb-4.0.3&crop=faces&fit=crop&w=32&h=32
                    ) : Parcelable

                    @Keep
                    @Parcelize
                    data class Social(
                        @SerializedName("instagram_username")
                        val instagramUsername: String, // theheartdept
                        @SerializedName("paypal_email")
                        val paypalEmail: String?, // null
                        @SerializedName("portfolio_url")
                        val portfolioUrl: String?, // null
                        @SerializedName("twitter_username")
                        val twitterUsername: String? // at8eqeq3
                    ) : Parcelable
                }
            }
        }
    }

    @Keep
    @Parcelize
    data class TagsPreview(
        val source: Source?,
        val title: String, // flower
        val type: String // landing_page
    ) : Parcelable {
        @Keep
        @Parcelize
        data class Source(
            val ancestry: Ancestry,
            @SerializedName("cover_photo")
            val coverPhoto: CoverPhoto,
            val description: String, // Choose from a curated selection of flower photos. Always free on Unsplash.
            @SerializedName("meta_description")
            val metaDescription: String, // Choose from hundreds of free flower pictures. Download HD flower photos for free on Unsplash.
            @SerializedName("meta_title")
            val metaTitle: String, // 500+ Flower Pictures [HD] | Download Free Images on Unsplash
            val subtitle: String, // Download free flower images
            val title: String // Flower images
        ) : Parcelable {
            @Keep
            @Parcelize
            data class Ancestry(
                val category: Category,
                val subcategory: Subcategory,
                val type: Type
            ) : Parcelable {
                @Keep
                @Parcelize
                data class Category(
                    @SerializedName("pretty_slug")
                    val prettySlug: String, // Nature
                    val slug: String // nature
                ) : Parcelable

                @Keep
                @Parcelize
                data class Subcategory(
                    @SerializedName("pretty_slug")
                    val prettySlug: String, // Flower
                    val slug: String // flower
                ) : Parcelable

                @Keep
                @Parcelize
                data class Type(
                    @SerializedName("pretty_slug")
                    val prettySlug: String, // Images
                    val slug: String // images
                ) : Parcelable
            }

            @Keep
            @Parcelize
            data class CoverPhoto(
                @SerializedName("alt_description")
                val altDescription: String, // pink rose flower
                @SerializedName("blur_hash")
                val blurHash: String, // L6R{lY-;_N%MtRofIUogtlofMwWB
                val color: String, // #f3f3f3
                @SerializedName("created_at")
                val createdAt: String, // 2017-08-15T15:10:43Z
                @SerializedName("current_user_collections")
                val currentUserCollections: List<String>?,
                val description: String, // It’s a personal opinion of mine that the more a flower fades, the more beautiful it becomes.
                val height: Int, // 4119
                val id: String, // fsdWYNTymjI
                @SerializedName("liked_by_user")
                val likedByUser: Boolean, // false
                val likes: Int, // 2842
                val links: Links,
                val plus: Boolean, // false
                val premium: Boolean, // false
                @SerializedName("promoted_at")
                val promotedAt: String, // 2017-08-16T15:26:28Z
                val sponsorship: String?, // null
                @SerializedName("topic_submissions")
                val topicSubmissions: TopicSubmissions?,
                @SerializedName("updated_at")
                val updatedAt: String, // 2023-04-30T10:01:49Z
                val urls: Urls,
                val user: User,
                val width: Int // 2942
            ) : Parcelable {
                @Keep
                @Parcelize
                data class Links(
                    val download: String, // https://unsplash.com/photos/fsdWYNTymjI/download
                    @SerializedName("download_location")
                    val downloadLocation: String, // https://api.unsplash.com/photos/fsdWYNTymjI/download
                    val html: String, // https://unsplash.com/photos/fsdWYNTymjI
                    val self: String // https://api.unsplash.com/photos/fsdWYNTymjI
                ) : Parcelable

                @Keep
                @Parcelize
                class TopicSubmissions : Parcelable

                @Keep
                @Parcelize
                data class Urls(
                    val full: String, // https://images.unsplash.com/photo-1502809737437-1d85c70dd2ca?ixlib=rb-4.0.3&q=85&fm=jpg&crop=entropy&cs=srgb
                    val raw: String, // https://images.unsplash.com/photo-1502809737437-1d85c70dd2ca?ixlib=rb-4.0.3
                    val regular: String, // https://images.unsplash.com/photo-1502809737437-1d85c70dd2ca?ixlib=rb-4.0.3&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=1080&fit=max
                    val small: String, // https://images.unsplash.com/photo-1502809737437-1d85c70dd2ca?ixlib=rb-4.0.3&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=400&fit=max
                    @SerializedName("small_s3")
                    val smallS3: String, // https://s3.us-west-2.amazonaws.com/images.unsplash.com/small/photo-1502809737437-1d85c70dd2ca
                    val thumb: String // https://images.unsplash.com/photo-1502809737437-1d85c70dd2ca?ixlib=rb-4.0.3&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=200&fit=max
                ) : Parcelable

                @Keep
                @Parcelize
                data class User(
                    @SerializedName("accepted_tos")
                    val acceptedTos: Boolean, // true
                    val bio: String, // Hi! I’m Tanalee. I'm a Believer, a wife, a mom, a US Army Veteran, a carpenter, a graphic designer, a photographer.  I AM a creative! 
                    @SerializedName("first_name")
                    val firstName: String, // Tanalee
                    @SerializedName("for_hire")
                    val forHire: Boolean, // false
                    val id: String, // AZlDcT0kEKM
                    @SerializedName("instagram_username")
                    val instagramUsername: String, // theheartdept
                    @SerializedName("last_name")
                    val lastName: String, // Youngblood
                    val links: Links,
                    val location: String, // Northern Kentucky
                    val name: String, // Tanalee Youngblood
                    @SerializedName("portfolio_url")
                    val portfolioUrl: String?, // null
                    @SerializedName("profile_image")
                    val profileImage: ProfileImage,
                    val social: Social,
                    @SerializedName("total_collections")
                    val totalCollections: Int, // 5
                    @SerializedName("total_likes")
                    val totalLikes: Int, // 60
                    @SerializedName("total_photos")
                    val totalPhotos: Int, // 18
                    @SerializedName("twitter_username")
                    val twitterUsername: String?, // null
                    @SerializedName("updated_at")
                    val updatedAt: String, // 2023-04-15T11:43:04Z
                    val username: String // theheartdept
                ) : Parcelable {
                    @Keep
                    @Parcelize
                    data class Links(
                        val followers: String, // https://api.unsplash.com/users/theheartdept/followers
                        val following: String, // https://api.unsplash.com/users/theheartdept/following
                        val html: String, // https://unsplash.com/it/@theheartdept
                        val likes: String, // https://api.unsplash.com/users/theheartdept/likes
                        val photos: String, // https://api.unsplash.com/users/theheartdept/photos
                        val portfolio: String, // https://api.unsplash.com/users/theheartdept/portfolio
                        val self: String // https://api.unsplash.com/users/theheartdept
                    ) : Parcelable

                    @Keep
                    @Parcelize
                    data class ProfileImage(
                        val large: String, // https://images.unsplash.com/profile-1502809342539-1dd464200dd4?ixlib=rb-4.0.3&crop=faces&fit=crop&w=128&h=128
                        val medium: String, // https://images.unsplash.com/profile-1502809342539-1dd464200dd4?ixlib=rb-4.0.3&crop=faces&fit=crop&w=64&h=64
                        val small: String // https://images.unsplash.com/profile-1502809342539-1dd464200dd4?ixlib=rb-4.0.3&crop=faces&fit=crop&w=32&h=32
                    ) : Parcelable

                    @Keep
                    @Parcelize
                    data class Social(
                        @SerializedName("instagram_username")
                        val instagramUsername: String, // theheartdept
                        @SerializedName("paypal_email")
                        val paypalEmail: String?, // null
                        @SerializedName("portfolio_url")
                        val portfolioUrl: String?, // null
                        @SerializedName("twitter_username")
                        val twitterUsername: String? // null
                    ) : Parcelable
                }
            }
        }
    }

    @Keep
    @Parcelize
    class TopicSubmissions : Parcelable

    @Keep
    @Parcelize
    data class Urls(
        val full: String, // https://images.unsplash.com/photo-1682101517859-7162f8372365?crop=entropy&cs=srgb&fm=jpg&ixid=Mnw0NDQ5NzV8MHwxfHJhbmRvbXx8fHx8fHx8fDE2ODMzNTc2MDY&ixlib=rb-4.0.3&q=85
        val raw: String, // https://images.unsplash.com/photo-1682101517859-7162f8372365?ixid=Mnw0NDQ5NzV8MHwxfHJhbmRvbXx8fHx8fHx8fDE2ODMzNTc2MDY&ixlib=rb-4.0.3
        val regular: String, // https://images.unsplash.com/photo-1682101517859-7162f8372365?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=Mnw0NDQ5NzV8MHwxfHJhbmRvbXx8fHx8fHx8fDE2ODMzNTc2MDY&ixlib=rb-4.0.3&q=80&w=1080
        val small: String, // https://images.unsplash.com/photo-1682101517859-7162f8372365?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=Mnw0NDQ5NzV8MHwxfHJhbmRvbXx8fHx8fHx8fDE2ODMzNTc2MDY&ixlib=rb-4.0.3&q=80&w=400
        @SerializedName("small_s3")
        val smallS3: String, // https://s3.us-west-2.amazonaws.com/images.unsplash.com/small/photo-1682101517859-7162f8372365
        val thumb: String // https://images.unsplash.com/photo-1682101517859-7162f8372365?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=Mnw0NDQ5NzV8MHwxfHJhbmRvbXx8fHx8fHx8fDE2ODMzNTc2MDY&ixlib=rb-4.0.3&q=80&w=200
    ) : Parcelable

    @Keep
    @Parcelize
    data class User(
        @SerializedName("accepted_tos")
        val acceptedTos: Boolean, // true
        val bio: String, // Lover of art and nature. All work done in-camera. "We see according to habits.  The role of art is to wrest us free of such habits." 
        @SerializedName("first_name")
        val firstName: String, // Evie
        @SerializedName("for_hire")
        val forHire: Boolean, // true
        val id: String, // zKou8F1Vm1o
        @SerializedName("instagram_username")
        val instagramUsername: String, // evieshaffer
        @SerializedName("last_name")
        val lastName: String, // S.
        val links: Links,
        val location: String, // U.S.A.
        val name: String, // Evie S.
        @SerializedName("portfolio_url")
        val portfolioUrl: String, // http://evies.com
        @SerializedName("profile_image")
        val profileImage: ProfileImage,
        val social: Social,
        @SerializedName("total_collections")
        val totalCollections: Int, // 8
        @SerializedName("total_likes")
        val totalLikes: Int, // 141
        @SerializedName("total_photos")
        val totalPhotos: Int, // 324
        @SerializedName("twitter_username")
        val twitterUsername: String, // evies
        @SerializedName("updated_at")
        val updatedAt: String, // 2023-05-03T01:47:17Z
        val username: String // evieshaffer
    ) : Parcelable {
        @Keep
        @Parcelize
        data class Links(
            val followers: String, // https://api.unsplash.com/users/evieshaffer/followers
            val following: String, // https://api.unsplash.com/users/evieshaffer/following
            val html: String, // https://unsplash.com/@evieshaffer
            val likes: String, // https://api.unsplash.com/users/evieshaffer/likes
            val photos: String, // https://api.unsplash.com/users/evieshaffer/photos
            val portfolio: String, // https://api.unsplash.com/users/evieshaffer/portfolio
            val self: String // https://api.unsplash.com/users/evieshaffer
        ) : Parcelable

        @Keep
        @Parcelize
        data class ProfileImage(
            val large: String, // https://images.unsplash.com/profile-fb-1515003070-191da6a69ab7.jpg?ixlib=rb-4.0.3&crop=faces&fit=crop&w=128&h=128
            val medium: String, // https://images.unsplash.com/profile-fb-1515003070-191da6a69ab7.jpg?ixlib=rb-4.0.3&crop=faces&fit=crop&w=64&h=64
            val small: String // https://images.unsplash.com/profile-fb-1515003070-191da6a69ab7.jpg?ixlib=rb-4.0.3&crop=faces&fit=crop&w=32&h=32
        ) : Parcelable

        @Keep
        @Parcelize
        data class Social(
            @SerializedName("instagram_username")
            val instagramUsername: String, // evieshaffer
            @SerializedName("paypal_email")
            val paypalEmail: String?, // null
            @SerializedName("portfolio_url")
            val portfolioUrl: String, // http://evies.com
            @SerializedName("twitter_username")
            val twitterUsername: String // evies
        ) : Parcelable
    }
}