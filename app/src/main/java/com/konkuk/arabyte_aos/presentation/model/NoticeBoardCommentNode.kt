package com.konkuk.arabyte_aos.presentation.model

data class NoticeBoardCommentNode(
    val comment: NoticeBoardDetailComment,
    val replies: MutableList<NoticeBoardCommentNode> = mutableListOf(),
)

fun buildCommentTree(flatList: List<NoticeBoardDetailComment>): List<NoticeBoardCommentNode> {
    val map = mutableMapOf<Long, NoticeBoardCommentNode>()
    val roots = mutableListOf<NoticeBoardCommentNode>()

    flatList.forEach { comment ->
        map[comment.commentId] = NoticeBoardCommentNode(comment)
    }

    flatList.forEach { comment ->
        val node = map[comment.commentId] ?: return@forEach
        if (comment.parentId == null || comment.parentId == 0L) {
            roots.add(node)
        } else {
            map[comment.parentId]?.replies?.add(node)
        }
    }
    return roots
}

data class FlattenComment(
    val comment: NoticeBoardDetailComment,
    val isReply: Boolean,
)

fun flattenCommentTree(tree: List<NoticeBoardCommentNode>): List<FlattenComment> {
    val result = mutableListOf<FlattenComment>()

    fun traverse(
        node: NoticeBoardCommentNode,
        isReply: Boolean,
    ) {
        result.add(FlattenComment(node.comment, isReply))
        node.replies.forEach { replyNode ->
            traverse(replyNode, isReply = true)
        }
    }
    tree.forEach { root ->
        traverse(root, isReply = false)
    }
    return result
}
