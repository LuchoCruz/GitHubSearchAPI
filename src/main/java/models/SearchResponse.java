package models;

import java.util.HashMap;

public class SearchResponse implements ResponseStructure {
    @Override
    public HashMap<String, String> getFields() {
        HashMap<String, String> fields = new HashMap<>();
        for (int i = 0; i < FIELDS.values().length; i++) {
            fields.put(FIELDS.values()[i].pathName, FIELDS.values()[i].fieldType);
        }
        return fields;
    }

    @Override
    public HashMap<String, String> getNonNestedItems() {
        HashMap<String, String> fields = new HashMap<>();
        for (int i = 0; i < FIELDS.values().length; i++) {
            if (!FIELDS.values()[i].pathName.contains(".")) {
                fields.put(FIELDS.values()[i].pathName, FIELDS.values()[i].fieldType);
            }
        }
        return fields;
    }

    enum FIELDS {
        total_count("total_count", "Integer"),
        incomplete_results("incomplete_results", "Boolean"),
        items_id("items.id", "Integer"),
        items_node_id("items.node_id", "String"),
        items_name("items.name", "String"),
        items_full_name("items.full_name", "String"),
        items_private("items.private", "Boolean"),
        items_owner_login("items.owner.login", "String"),
        items_owner_id("items.owner.id", "Integer"),
        items_owner_node_id("items.owner.node_id", "String"),
        items_owner_avatar_url("items.owner.avatar_url", "String"),
        items_owner_gravatar_id("items.owner.gravatar_id", "String"),
        items_owner_url("items.owner.url", "String"),
        items_owner_html_url("items.owner.html_url", "String"),
        items_owner_following_url("items.owner.following_url", "String"),
        items_owner_gists_url("items.owner.gists_url", "String"),
        items_owner_starred_url("items.owner.starred_url", "String"),
        items_owner_subscriptions_url("items.owner.subscriptions_url", "String"),
        items_owner_organizations_url("items.owner.organizations_url", "String"),
        items_owner_repos_url("items.owner.repos_url", "String"),
        items_owner_events_url("items.owner.events_url", "String"),
        items_owner_received_events_url("items.owner.received_events_url", "String"),
        items_owner_type("items.owner.type", "String"),
        items_owner_site_admin("items.owner.site_admin", "Boolean"),
        items_html_url("items.html_url", "String"),
        items_description("items.description", "String"),
        items_fork("items.fork", "Boolean"),
        items_url("items.url", "String"),
        items_forks_url("items.forks_url", "String"),
        items_keys_url("items.keys_url", "String"),
        items_collaborators_url("items.collaborators_url", "String"),
        items_teams_url("items.teams_url", "String"),
        items_hooks_url("items.hooks_url", "String"),
        items_issue_events_url("items.issue_events_url", "String"),
        items_events_url("items.events_url", "String"),
        items_assignees_url("items.assignees_url", "String"),
        items_branches_url("items.branches_url", "String"),
        items_tags_url("items.tags_url", "String"),
        items_blobs_url("items.blobs_url", "String"),
        items_git_tags_url("items.git_tags_url", "String"),
        items_git_refs_url("items.git_refs_url", "String"),
        items_trees_url("items.trees_url", "String"),
        items_statuses_url("items.statuses_url", "String"),
        items_languages_url("items.languages_url", "String"),
        items_stargazers_url("items.stargazers_url", "String"),
        items_contributors_url("items.contributors_url", "String"),
        items_subscribers_url("items.subscribers_url", "String"),
        items_subscription_url("items.subscription_url", "String"),
        items_commits_url("items.commits_url", "String"),
        items_git_commits_url("items.git_commits_url", "String"),
        items_comment_url("items.comments_url", "String"),
        items_issue_comments_url("items.issue_comment_url", "String"),
        items_contents_url("items.contents_url", "String"),
        items_compare_url("items.compare_url", "String"),
        items_merges_url("items.merges_url", "String"),
        items_archive_url("items.archive_url", "String"),
        items_downloads_url("items.downloads_url", "String"),
        items_issues_url("items.issues_url", "String"),
        items_pulls_url("items.pulls_url", "String"),
        items_milestones_url("items.milestones_url", "String"),
        items_notifications_url("items.notifications_url", "String"),
        items_labels_url("items.labels_url", "String"),
        items_releases_url("items.releases_url", "String"),
        items_deployments_url("items.deployments_url", "String"),
        items_created_at("items.created_at", "String"),
        items_updated_at("items.updated_at", "String"),
        items_pushed_at("items.pushed_at", "String"),
        items_git_url("items.git_url", "String"),
        items_ssh_url("items.ssh_url", "String"),
        items_clone_url("items.clone_url", "String"),
        items_svn_url("items.svn_url", "String"),
        items_homepage("items.homepage", "String"),
        items_size("items.size", "Integer"),
        items_stargazers_count("items.stargazers_count", "Integer"),
        items_watchers_count("items.watchers_count", "Integer"),
        items_language("items.language", "String"),
        items_has_issues("items.has_issues", "Boolean"),
        items_has_projects("items.has_projects", "Boolean"),
        items_has_downloads("items.has_downloads", "Boolean"),
        items_has_wiki("items.has_wiki", "Boolean"),
        items_has_pages("items.has_pages", "Boolean"),
        items_forks_count("items.forks_count", "Integer"),
        items_mirror_url("items.mirror_url", "String"),
        items_archived("items.archived", "Boolean"),
        items_disabled("items.disabled", "Boolean"),
        items_open_issues_count("items.open_issues_count", "Integer"),
        items_license("items.license", "String"),
        items_forks("items.forks", "Integer"),
        items_open_issues("items.open_issues", "Integer"),
        items_watchers("items.watchers", "Integer"),
        items_default_branch("items.default_branch", "String"),
        items_score("items.score", "Float");

        private final String pathName;
        private final String fieldType;

        FIELDS(final String pathName, final String fieldType) {
            this.pathName = pathName;
            this.fieldType = fieldType;
        }
    }
}
