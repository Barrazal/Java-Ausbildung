package javascript;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/* 
		 * 
		 * 
		 * 
class Towfiq_Person {
  static function on_load() {
    add_action('init',array(__CLASS__,'init'));
    add_action('wp_insert_post',array(__CLASS__,'wp_insert_post'),10,2);
    add_action('profile_update',array(__CLASS__,'profile_update'),10,2);
    add_action('user_register',array(__CLASS__,'profile_update'));
    add_filter('author_link',array(__CLASS__,'author_link'),10,2);
    add_filter('get_the_author_url',array(__CLASS__,'author_link'),10,2);
  }
  static function init() {
    register_post_type('towfiq-person',
      array(
        'labels'          => array('name'=>'People','singular_name'=>'Person'),
        'public'          => true,
        'show_ui'         => true,
        'rewrite'         => array('slug' => 'people'),
        'hierarchical'    => false,
        //'supports'        => array('title','editor','custom-fields'),
      )
    );
  }
  static function get_email_key() {
    return apply_filters( 'person_email_key', '_email' );
  }
  static function profile_update($user_id,$old_user_data=false) {
    global $wpdb;
    $is_new_person = false;
    $user = get_userdata($user_id);
    $user_email = ($old_user_data ? $old_user_data->user_email : $user->user_email);
    $email_key = self::get_email_key();
    $person_id = $wpdb->get_var($wpdb->prepare("SELECT post_id FROM {$wpdb->postmeta} WHERE meta_key='%s' AND meta_value='%s'",$email_key,$user_email));
    if (!is_numeric($person_id)) {
      $person_id = $is_new_person = wp_insert_post(array(
        'post_type' => 'towfiq-person',
        'post_status' => 'publish',   // Maybe this should be pending or draft?
        'post_title' => $user->display_name,
      ));
    }
    update_user_meta($user_id,'_person_id',$person_id);
    update_post_meta($person_id,'_user_id',$user_id);
    if ($is_new_person || ($old_user_data && $user->user_email!=$old_user_data->user_email)) {
      update_post_meta($person_id,$email_key,$user->user_email);
    }
  }
  static function wp_insert_post($person_id,$person) {
    if ($person->post_type=='towfiq-person') {
      $email = get_post_meta($person_id,self::get_email_key(),true);
      if (filter_var($email, FILTER_VALIDATE_EMAIL)) {
        $user = get_user_by('email',$email);
        if ($user) { // Associate the user IF there is an user with the same email address
          update_user_meta($user->ID,'_person_id',$person_id);
          update_post_meta($person_id,'_user_id',$user->ID);
        } else {
          delete_post_meta($person_id,'_user_id');
        }
      }
    }
  }
  static function get_user_id($person_id) {
    return get_user_meta($user_id,'_user_id',true);
  }
  static function get_user($person_id) {
    $user_id = self::get_user_id($person_id);
    return get_userdata($user_id);
  }
  static function get_person_id($user_id) {
    return get_user_meta($user_id,'_person_id',true);
  }
  static function get_person($user_id) {
    $person_id = self::get_person_id($user_id);
    return get_post($person_id);
  }
  static function author_link($permalink, $user_id) {
    $author_id = get_user_meta($user_id,'_person_id',true);
    if ($author_id) // If an associate is found, use it
      $permalink = get_post_permalink($author_id);
    return $permalink;
  }
}
Towfiq_Person::on_load();
		 * 
		 * 
		 * 
		 * 
		 */
		
		
		
	}

}
